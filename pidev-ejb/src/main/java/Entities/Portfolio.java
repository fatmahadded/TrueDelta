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
    private int id; //Clé primaire
	
    @Column(name="GainCount")
    private int gain; 
    @Column(name="RiskCount")
    private int risk;
    @Column(name="Amount")
    private int amount;
   
    
    private int nb_purchased_bond; 
	private int nb_purchased_stock; 
	 
	
	@ManyToOne
	private Client client; 
    @OneToOne
    private Conflict conflict;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="Portfolios")
    private Set<Messages> Messages;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="Portfolios")
    
    private Set<Feedback> Feedbacks;
    @ManyToOne
    AssetManager AssetManager;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy="Portfolio")
    private Set<Transaction> Transactions;
    
    public Portfolio() {}
    
    public Portfolio(int id, int gain, int risk, int amount,int nb_purchased_bond,int nb_purchased_stock) {
		super();
		this.id = id;
		this.gain = gain;
		this.risk = risk;
		this.amount = amount;
		this.nb_purchased_stock=nb_purchased_stock;
		this.nb_purchased_bond= nb_purchased_bond;
	}
    
    public int getId() {
    	return id;
    }
    public void setId(int id) {
    	this.id= id;
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
    public Set<Messages> getMessages() {
    	return Messages;
    }
    public void setMessages(Set<Messages> messages) {
    	Messages = messages;
    }
    //*****************************************
    //**************************************
    public Set<Feedback> getFeedbacks() {
    	return Feedbacks;
    }
    public void setFeedbacks(Set<Feedback> feedbacks) {
    	Feedbacks = feedbacks;}
    //public void SetFeedbacks(List<Feedback> feedbacks) {
		//Feedbacks = (Set<Feedback>) feedbacks;}
    //*********************************************
    //*****************************************
    public AssetManager getAssetManager() {
    	return AssetManager;
    }
    public void setAssetManager(AssetManager assetManager) {
    	AssetManager = assetManager;
    }
    public Client getClient() {
    	return client;
    }
    public void setClient(Client client) {
    	this.client = client;
    }
    public int getNb_purchased_bond() {
		return nb_purchased_bond;
	}

	public void setNb_purchased_bond(int nb_purchased_bond) {
		this.nb_purchased_bond = nb_purchased_bond;
	}

	public int getNb_purchased_stock() {
		return nb_purchased_stock;
	}
	public void setNb_purchased_stock(int nb_purchased_stock) {
		this.nb_purchased_stock = nb_purchased_stock;
	}
	
	

    public Set<Transaction> getTransactions() {
    	return Transactions;
    }
    public void setTransactions(Set<Transaction> transactions) {
    	Transactions = transactions;
    }
	
	public void addTransaction(Transaction transaction) {
		this.Transactions.add(transaction);}
	public void addFeedBack(Feedback feedback) {
			this.Feedbacks.add(feedback);}
	@Override
	public String toString() {
	return "Portfolio [id=" + id + ", gain=" + gain + ", risk=" + risk
	+ ", amount=" + amount + "nb_purchased_bond=" + nb_purchased_bond + ", nb_purchased_stock="
	+nb_purchased_stock +",client=" +client+ "]";
	}
// private Set<Feedback> Feedbacks;
	public void addFeedabck(Feedback fe){
		this.Feedbacks.add(fe);
	}
}
