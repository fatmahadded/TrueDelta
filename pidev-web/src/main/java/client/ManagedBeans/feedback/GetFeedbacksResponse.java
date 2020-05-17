package client.ManagedBeans.feedback;

import java.io.Serializable;
import java.util.List;



public class GetFeedbacksResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static class SingleFeedback{
		private int id;
		private int score ;
		
		
		
		public  SingleFeedback(int feedback_id, int score) {
			super();
			this.id = feedback_id;
			this.score = score;
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public double getScore() {
			return score;
		}



		public void setAmount(int score) {
			this.score = score;
		}
		
		
		
		
	}
	
	private List<SingleFeedback> feedbacks;
	private String message;
	
	public GetFeedbacksResponse() {
		
	}
	
	public GetFeedbacksResponse(List<SingleFeedback> feedback, String message, List<SingleFeedback> feedbacks) {
		super();
		this.feedbacks = feedbacks;
		this.message = message;
	}
	
	
	public List<SingleFeedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<SingleFeedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
