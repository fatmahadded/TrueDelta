package client.ManagedBeans.feedback;

public class UpdateFeedbackResponse {
	
		private int feedback;
		private String message;
		
		public UpdateFeedbackResponse() {
		}
		
		public UpdateFeedbackResponse(int f) {
			this.feedback = f;
		}

		public int getFeedback() {
			return feedback;
		}

		public void setFeedback(int feedback) {
			this.feedback = feedback;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		
}
