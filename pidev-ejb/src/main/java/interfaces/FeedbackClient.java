package interfaces;

import java.util.List;

import javax.ejb.Local;

import Entities.Portfolio;
import Entities.Contract;
import Entities.Feedback;

@Local
public interface FeedbackClient {
	public int addFeedback(int idportfolio, Feedback feedback);
	public int updateFeedback(Feedback newfeed);
	public Feedback getFeedback(int idfeedback);
	public List<Feedback> getPortfolioFeedbacks(int idportfolio);
    public void ajouterFeedback(Feedback feedback);
		
}
