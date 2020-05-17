package client.ManagedBeans.feedback;

import java.io.Serializable;


import Entities.Feedback;;

public class GetFeedbackResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int feedback_id;
	private int score;
	private String message;

	public  GetFeedbackResponse() {
		
	}
	
	public  GetFeedbackResponse(int feedback_id, int score, String message) {
		super();
		this.feedback_id = feedback_id;
		this.score =score;
		this.message = message;
	}
	
	public int getFeedback_id() {
		return feedback_id;
	}

	public void setTransaction_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public double getScore() {
		return score;
	}

	public void setTransaction_amount(int score) {
		this.score = score;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
