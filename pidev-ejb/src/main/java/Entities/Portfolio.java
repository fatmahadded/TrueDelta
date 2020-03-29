package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Portfolio")
public class Portfolio implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id; // Clé primaire
	@Column(name = "Gain")
	private int gain;
	@Column(name = "Risk")
	private int risk;
	@Column(name = "Amount")
	private int amount;

	@OneToOne
	private Conflict conflict;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Portfolios")
	private List<Messages> Messages = new ArrayList<Messages>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Portfolios")
	private List<Feedback> Feedbacks = new ArrayList<Feedback>();

	@ManyToOne
	AssetManager AssetManager;

	@ManyToOne
	Client Client;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Portfolio")
	private List<Transaction> Transactions = new ArrayList<Transaction>();

	public Portfolio() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGain() {
		return gain;
	}

	public void setGain(int gain) {
		this.gain = gain;
	}

	public int getRisk() {
		return risk;
	}

	public void setRisk(int risk) {
		this.risk = risk;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Conflict getConflict() {
		return conflict;
	}

	public void setConflict(Conflict conflict) {
		this.conflict = conflict;
	}

	public List<Messages> getMessages() {
		return Messages;
	}

	public void setMessages(List<Messages> messages) {
		Messages = messages;
	}

	public List<Feedback> getFeedbacks() {
		return Feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		Feedbacks = feedbacks;
	}

	public AssetManager getAssetManager() {
		return AssetManager;
	}

	public void setAssetManager(AssetManager assetManager) {
		AssetManager = assetManager;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public List<Transaction> getTransactions() {
		return Transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		Transactions = transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		this.Transactions.add(transaction);
	}

}
