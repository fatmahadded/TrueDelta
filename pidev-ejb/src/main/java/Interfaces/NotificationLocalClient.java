package interfaces;

import java.util.List;
import javax.ejb.Local;

import Entities.Notification;


@Local
public interface NotificationLocalClient {
	public Notification addNotification(long idFrom, long idTo, String content);
	public boolean removeNotification(long notifId);
	public Notification editNotification(Notification notification);
	public List<Notification> getNotificationHistoryOfUser(long clientId);
	public Notification getNotifById(long id);
	public List<Notification> getAll();
	public List<Notification> getNotifsOfPortfolio(long portfolioId);

	public List<String> getAllFeedbackMessagessByClient(int clientId) ;
}
