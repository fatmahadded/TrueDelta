package interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import Entities.Portfolio;
import Entities.Transaction;

@Local
public interface ITransactionLocalService {
	public int addTransaction(int portfolio_id, Transaction T);
	public int updateTransaction(Transaction T);
	public Transaction getTransaction(int id_transaction);
	public List<Transaction> getPortfolioTransactions(int id_portfolio);
	public List<Object> getMarketData(String company, Date from, Date to);
	public Portfolio getMinimalPortfolio();
}
