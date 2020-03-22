package Entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table( name= "Messages")
public class Messages implements Serializable{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="IdMassage")
private int id; // Clé primaire
@Column(name="Mesage")

private String message ; 
@Column(name="DateMessage")
private Date date;

@ManyToOne
Portfolio Portfolios;

public Messages() {}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Portfolio getPortfolios() {
	return Portfolios;
}

public void setPortfolios(Portfolio portfolios) {
	Portfolios = portfolios;
}


}
