package Transactions.ViewModels;


public class UpdateTransactionResponse {
	private int transaction;
	private String message;
	
	public UpdateTransactionResponse() {
	}
	
	public UpdateTransactionResponse(int t) {
		this.transaction = t;
	}

	public int getTransaction() {
		return transaction;
	}

	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
