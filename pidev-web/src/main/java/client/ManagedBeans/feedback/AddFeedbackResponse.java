package client.ManagedBeans.feedback;

import java.io.Serializable;

public class AddFeedbackResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int Feedback_ID;

	public AddFeedbackResponse() {
		
	}
	
	public int getFeedback_ID() {
		return Feedback_ID;
	}

	public void setTransaction_ID(int feedback_ID) {
		Feedback_ID = feedback_ID;
	}
	

}
