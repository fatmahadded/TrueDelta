package Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdFeed")
	private int idfeed; // Clé primaire
	@Column(name = "MessageFeed")
	private String message;
	@Column(name = "Score")
	private int score;
	@Column(name = "date_of_emssion")
	LocalDateTime dateOfEmission;

	@ManyToOne
	Portfolio Portfolios;
//sender
	@ManyToOne
	@JoinColumn(name = "sender_id")
	Client sender;
//reciever
	@ManyToOne
	@JoinColumn(name = "reciver_id")
	AssetManager reciever;

	public Feedback() {
		super();
	}

	public int getIdFeed() {
		return idfeed;
	}

	public void setIdFeed(int idfeed) {
		this.idfeed = idfeed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateOfEmission() {
		return dateOfEmission;
	}

	public void setDateOfEmission(LocalDateTime dateOfEmission) {
		this.dateOfEmission = dateOfEmission;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}

	public AssetManager getReciever() {
		return reciever;
	}

	public void setReciever(AssetManager reciever) {
		this.reciever = reciever;
	}

	public Portfolio getPortfolios() {
		return Portfolios;
	}

	public void setPortfolios(Portfolio portfolios) {
		Portfolios = portfolios;
	}

}
