package Transactions.ViewModels;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

@Transactional
public class GetTransactionsResponse implements Serializable{
	public static class SingleTransaction{
		private int id;
		private double amount;
		
		
		
		public SingleTransaction(int transaction_id, double transaction_amount) {
			super();
			this.id = transaction_id;
			this.amount = transaction_amount;
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public double getAmount() {
			return amount;
		}



		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		
		
		
	}
	
	private List<SingleTransaction> transactions;
	private String message;
	
	public GetTransactionsResponse() {
		
	}
	
	public GetTransactionsResponse(List<SingleTransaction> transaction, String message) {
		super();
		this.transactions = transaction;
		this.message = message;
	}
	
	
	public List<SingleTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<SingleTransaction> transactions) {
		this.transactions = transactions;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
