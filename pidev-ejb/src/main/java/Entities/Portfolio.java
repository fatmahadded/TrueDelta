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
@Table( name= "Portfolio")
public class Portfolio implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IDCount")
    private int id; // Clé primaire
    @Column(name="GainCount")
    private int gain; 
    @Column(name="RiskCount")
    private int risk;
    @Column(name="AmountCount")
    private double amount;
    
    @OneToOne
    private Conflict conflict;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="Portfolios")
    private Set<Messages> Messages;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="Portfolios")
    private Set<Feedback> Feedbacks;
    
    @ManyToOne
    AssetManager AssetManager;
    
    @ManyToOne
    Client Client;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="Portfolio")
    private Set<Transaction> Transactions;
    
    public Portfolio() {}
    
    public Portfolio(int id, int gain, int risk, int amount) {
		super();
		this.id = id;
		this.gain = gain;
		this.risk = risk;
		this.amount = amount;
		
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
    public double getAmount() {
    	return amount;
    }
    public void setAmount(double amount) {
    	this.amount = amount;
    }
    public Conflict getConflict() {
    	return conflict;
    }
    public void setConflict(Conflict conflict) {
    	this.conflict = conflict;
    }
    public Set<Messages> getMessages() {
    	return Messages;
    }
    public void setMessages(Set<Messages> messages) {
    	Messages = messages;
    }
    public Set<Feedback> getFeedbacks() {
    	return Feedbacks;
    }
    public void setFeedbacks(Set<Feedback> feedbacks) {
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
    public Set<Transaction> getTransactions() {
    	return Transactions;
    }
    public void setTransactions(Set<Transaction> transactions) {
    	Transactions = transactions;
    }
	
	public void addTransaction(Transaction transaction) {
		this.Transactions.add(transaction);
	}


}
