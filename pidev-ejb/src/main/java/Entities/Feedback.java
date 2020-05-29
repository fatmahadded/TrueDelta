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

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="IdFeed")
private int idfeedback; // Clé primaire
@Column(name="MessageFeed")
private String message;
//raiting
@Column(name="Score_Given_To_AM")
private int score;

//****relation****

@ManyToOne
Portfolio Portfolios;

//*-**********constructeur
public Feedback() {		super();
}
public Feedback(String message,int score) {
	this.message=message;
	this.score=score;
}
public Feedback(int idfeedback,String message,int score) {
	this.idfeedback=idfeedback;
	this.message=message;
	this.score=score;
}









//getter setter cle

public int getId() {
	return idfeedback;
}
public void setId( int idfeedback) {
	this.idfeedback = idfeedback;
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

//getter setter relation
public Portfolio getPortfolios() {
	return Portfolios;
}

public void setPortfolios(Portfolio portfolios) {
	Portfolios = portfolios;
}


//to string
//*****methode to string****
	@Override
	public String toString() {
	return "Feedback [id=" + idfeedback + ",Message=" + message + ", score=" + score
	+ "]";
	}









}
