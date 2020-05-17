package interfaces;

import java.util.List;

import javax.ejb.Local;

import Entities.Portfolio;
import Entities.Feedback;

@Local
public interface FeedbackClient {
	public int addFeedback(int portfolioId, Feedback feed);
	public int updateFeedback(Feedback feed);
	public Feedback getFeedback(int feedId);
	public List<Feedback> getPortfolioFeedbacks(int portfolioId);

}
