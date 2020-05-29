package Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    private int idportfolio; //Clé primaire
	
    @Column(name="GainCount")
    private int gain; 
    @Column(name="RiskCount")
    private int risk;
    @Column(name="Amount")
    private int amount;
   
    ///////*******relation
    @ManyToOne
	Client Clients;
     public int getIdportfolio() {
		return idportfolio;
	}

	public void setIdportfolio(int idportfolio) {
		this.idportfolio = idportfolio;
	}

	public Client getClients() {
		return Clients;
	}

	public void setClients(Client clients) {
		Clients = clients;
	}

	@ManyToOne
	 AssetManager AssetManager;
	 @OneToOne
    private Conflict conflict;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="Portfolios")
    private Set<Messages> Messages;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="Portfolios")
     private Set<Feedback> Feedbacks;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy="Portfolio")
    private Set<Transaction> Transactions;
    
    
    //constructeur
    public Portfolio() {}
    
    public Portfolio(int idportfolio, int gain, int risk, int amount) {
		super();
		this.idportfolio = idportfolio;
		this.gain = gain;
		this.risk = risk;
		this.amount = amount;
	}
   //getters and setters cle
    public int getId() {
    	return idportfolio;
    }
    public void setId( int idportfolio) {
    	this.idportfolio= idportfolio;
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
    //getters setters relation
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
    	Feedbacks = feedbacks;}
   
    public AssetManager getAssetManager() {
    	return AssetManager;
    }
    public void setAssetManager(AssetManager assetManager) {
    	AssetManager = assetManager;
    }
   
 
    public Set<Transaction> getTransactions() {
    	return Transactions;
    }
    public void setTransactions(Set<Transaction> transactions) {
    	Transactions = transactions;
    }
    
    //*****methode**************
	
	public void addTransaction(Transaction transaction) {
		this.Transactions.add(transaction);}
	public void addFeedBack(Feedback feedback) {
			this.Feedbacks.add(feedback);}
	
	//*****methode to string****
	@Override
	public String toString() {
	return "Portfolio [id=" + idportfolio + ", gain=" + gain + ", risk=" + risk
	+ ", amount=" + amount +",client=" +Clients+ "]";
	}
// private Set<Feedback> Feedbacks;
	
}
