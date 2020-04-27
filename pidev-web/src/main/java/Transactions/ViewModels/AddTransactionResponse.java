package Transactions.ViewModels;

import java.io.Serializable;

public class AddTransactionResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int Transaction_ID;

	public AddTransactionResponse() {
		
	}
	
	public int getTransaction_ID() {
		return Transaction_ID;
	}

	public void setTransaction_ID(int transaction_ID) {
		Transaction_ID = transaction_ID;
	}
	
}
