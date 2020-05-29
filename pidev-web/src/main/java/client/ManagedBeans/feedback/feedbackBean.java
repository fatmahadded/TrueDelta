package client.ManagedBeans.feedback;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import Entities.Feedback;
import services.FeedbackClientService ;


@ManagedBean (name="feedbackBean")
@SessionScoped






public class feedbackBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String message;
	private int score;
	private Integer contractIdToBeUpdated;
	Feedback feedback;
	
	
	
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
	public Integer getContractIdToBeUpdated() {
		return contractIdToBeUpdated;
	}


	public void setContractIdToBeUpdated(Integer contractIdToBeUpdated) {
		this.contractIdToBeUpdated = contractIdToBeUpdated;
	}  
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;}
	
	@EJB
	FeedbackClientService feedbackService;
	
	public void addFeedback() {
		
		feedback= (new Feedback(message, score));

		feedbackService.ajouterFeedback(feedback);
		}
		
		

}
