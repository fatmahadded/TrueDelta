package ManagedBeans.transactions;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import Entities.Transaction;
import interfaces.ITransactionLocalService;

@ManagedBean
@ApplicationScoped
public class TransactionsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	ITransactionLocalService service;
	
	private List<Transaction> transactions;
	private Transaction selectedTransaction;
	private int quantity = 0;
	private double amount = 0;
	public List<Transaction> getTransactions() {
		this.transactions = service.getPortfolioTransactions(1);
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public void update() {
		Transaction T = service.getTransaction(selectedTransaction.getId());
		T.setAmount(this.amount);
		T.setQuantite(this.quantity);
		service.updateTransaction(T);
		RequestContext.getCurrentInstance().execute("updateWidget.hide();");
	}

	public Transaction getSelectedTransaction() {
		return selectedTransaction;
	}

	public void setSelectedTransaction(Transaction selectedTransaction) {
		this.amount = selectedTransaction.getAmount();
		this.quantity = selectedTransaction.getQuantite();
		this.selectedTransaction = selectedTransaction;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
