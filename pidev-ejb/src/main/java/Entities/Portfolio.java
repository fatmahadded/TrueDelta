package Entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
private int idcount; // Clé primaire
@Column(name="GainCount")
private int gain; 
@Column(name="RiskCount")
private int risk;
@Column(name="AmountCount")
private int amount;

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


public int getIDCount() {
	return idcount;
}
public void setIDCount(int idcount) {
	this.idcount = idcount;
}
public int getGainCount() {
	return gain;
}
public void setGainCount(int gain) {
	this.gain = gain;
}
public int getRiskCount() {
	return risk;
}
public void setRiskCount(int risk) {
	this.risk = risk;
}
public int getAmountCount() {
	return amount;
}
public void setAmountCount(int amount) {
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

public Portfolio() {}
public Portfolio(int idcount, int gain, int risk, int amount) {
	super();
	this.idcount = idcount;
	this.gain = gain;
	this.risk = risk;
	this.amount = amount;
	
}

}
