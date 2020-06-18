package interfaces;

import java.util.List;

import Entities.Feedback;

public interface FeedbackClient {
	public Feedback addFeedback(long idFrom, long idTo, String message);

	public boolean removeFeedback(long idfeed);

	public Feedback editFeedback(Feedback feedback);

	public List<Feedback> getFeedbackHistoryOfClient(long idclient);

	public Feedback getFeedbackById(long idfeed);

	public List<Feedback> getAll();

}
