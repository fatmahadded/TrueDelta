package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name= "Transaction")
public class Transaction implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="IdTransaction")
private int id; // Clé primaire
@Column(name="=NameTransaction")
private double amount;

@ManyToOne
Portfolio Portfolio;

public Transaction() {}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public Portfolio getPortfolio() {
	return Portfolio;
}

public void setPortfolio(Portfolio portfolio) {
	Portfolio = portfolio;
}


}
