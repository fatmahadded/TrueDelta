package Entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table( name= "Portfolio")
public class Portfolio implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="CONT_ID")
private int id; // Clé primaire
@Column(name="CONT_GAIN")
private int gain; 
@Column(name="CONT_RISK")
private int risk;
@Column(name="CONT_AMOUNT")
private int amount;
// Constructeur et accesseurs (getters) et mutateurs (setters)
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

}
