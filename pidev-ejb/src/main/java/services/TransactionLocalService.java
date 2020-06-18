package services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Portfolio;
import Entities.Transaction;
import interfaces.ITransactionLocalService;

@Stateless
public class TransactionLocalService implements ITransactionLocalService {

	@PersistenceContext
	EntityManager em;

	@Override
	public int addTransaction(int portfolio_id, Transaction T) {
		Portfolio p = em.find(Portfolio.class, portfolio_id);
		Query query = em.createQuery("SELECT SUM(t.amount) FROM Transaction t");
		double transactions_total_amount = 0;
		if(query.getSingleResult() != null) {
			transactions_total_amount = (double)query.getSingleResult();
		}
		if (transactions_total_amount < p.getAmount()
				&& ((transactions_total_amount + T.getAmount()) <= p.getAmount())) {
			p.setTransactions(new HashSet<Transaction>());
			p.addTransaction(T);
			T.setPortfolio(p);
			em.persist(T);
			return T.getId();
		}
		return 0;
	}

	@Override
	public int updateTransaction(Transaction T) {
		Transaction oldT = em.find(Transaction.class, T.getId());
		Portfolio p = em.find(Portfolio.class, oldT.getPortfolio().getId());
		double transactions_total_amount = em.createQuery("SELECT SUM(t.amount) FROM Transaction t", Double.class)
				.getSingleResult();
		if (((transactions_total_amount - oldT.getAmount()) < p.getAmount())
				&& (((transactions_total_amount - oldT.getAmount()) + T.getAmount()) <= p.getAmount())) {
			T.setPortfolio(p);
			em.merge(T);
		}
		return oldT.getId();
	}

	@Override
	public Transaction getTransaction(int id_transaction) {
		Transaction T = em.find(Transaction.class, id_transaction);
		return T;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getPortfolioTransactions(int id_portfolio) {
		Query transactions = em
				.createQuery("select t from Transaction t where t.Portfolio.id = :portfolio_id", Transaction.class)
				.setParameter("portfolio_id", id_portfolio);
		return transactions.getResultList();
	}

	@Override
	public List<Object> getMarketData(String company, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Portfolio getMinimalPortfolio() {
		// TODO Auto-generated method stub
		return null;
	}

}
