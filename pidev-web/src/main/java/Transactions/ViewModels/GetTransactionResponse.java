package Transactions.ViewModels;

import java.io.Serializable;


import Entities.Transaction;


public class GetTransactionResponse implements Serializable{
	private int transaction_id;
	private double transaction_amount;
	private String message;
	
	public GetTransactionResponse() {
		
	}
	
	public GetTransactionResponse(int transaction_id, double transaction_amount, String message) {
		super();
		this.transaction_id = transaction_id;
		this.transaction_amount = transaction_amount;
		this.message = message;
	}
	
	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public double getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
