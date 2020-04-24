package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Portfolio;
import Entities.Transaction;
import interfaces.ITransactionLocalService;

@Stateless
public class TransactionLocalService implements ITransactionLocalService{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public int addTransaction(int portfolio_id, Transaction T) {
		Portfolio p = em.find(Portfolio.class, portfolio_id);
		p.setTransactions(new HashSet<Transaction>());
		p.addTransaction(T);
		T.setPortfolio(p);
		em.persist(T);
		return T.getId();
	}

	@Override
	public int updateTransaction(Transaction T) {
		Transaction oldT = em.find(Transaction.class, T.getId());
		Portfolio p = em.find(Portfolio.class, oldT.getPortfolio().getId());
		T.setPortfolio(p);
		em.merge(T);
		return T.getId();
	}

	@Override
	public Transaction getTransaction(int id_transaction) {
		Transaction T = em.find(Transaction.class, id_transaction);
		return T;
	}

	@Override
	public List<Transaction> getPortfolioTransactions(int id_portfolio) {
		Query transactions = em.createQuery("select t from Transaction t where t.Portfolio.id = :portfolio_id").setParameter("portfolio_id",id_portfolio);
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
