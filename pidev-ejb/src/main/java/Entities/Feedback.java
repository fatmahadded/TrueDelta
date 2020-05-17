package Entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name= "Feedback")
public class Feedback implements Serializable{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="IdFeed")
private int id; // Clé primaire
@Column(name="MessageFeed")
private String message;
//raiting
@Column(name="Score_Given_To_AM")
private int score;



@ManyToOne
Portfolio Portfolios;


public Feedback() {	}

public int getId() {
	return id;
}

public void setId( int id) {
	this.id = id;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public int getScore() {
	return score;
}

public void setScore(int score) {
	this.score = score;
}


public Portfolio getPortfolios() {
	return Portfolios;
}

public void setPortfolios(Portfolio portfolios) {
	Portfolios = portfolios;
}



}
