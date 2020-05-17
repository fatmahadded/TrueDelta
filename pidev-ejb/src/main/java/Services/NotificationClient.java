package services;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import interfaces.NotificationLocalClient;
import Entities.Feedback;
import Entities.Notification;
import Entities.User;

@Stateless
public class NotificationClient implements NotificationLocalClient {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Notification addNotification(long idFrom, long idTo, String content) {
		Notification notification = new Notification();
		notification.setContent(content);
		User reciever = em.find(User.class, idTo);
		User sender = em.find(User.class, idFrom);
		notification.setSender(sender);
		notification.setReciever(reciever);
		notification.setSeen(false);
		notification.setDateOfEmission(LocalDateTime.now());
		em.persist(notification);
		em.flush();
		return em.find(Notification.class, notification.getId());
	}

	@Override
	public boolean removeNotification(long notifId) {
		Notification n = em.find(Notification.class, notifId);
		if (n!=null) {
			em.remove(n);
			return true;
		}
		return false;
	}

	@Override
	public Notification editNotification(Notification notification) {
		em.merge(notification);
		em.flush();
		return em.find(Notification.class, notification.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> getNotificationHistoryOfUser(long clientId) {
		return em.createQuery("SELECT n from Notification n where n.reciever.id = :id order by n.dateOfEmission DESC")
				.setParameter("id", clientId).getResultList();
	}

	@Override
	public Notification getNotifById(long id) {
		return (Notification) em.createQuery("SELECT n from Notification n where n.id = "+id).getSingleResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> getAll() {
		return em.createQuery("SELECT n from Notification n ")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> getNotifsOfPortfolio(long portfolioId) {
		return em.createQuery("SELECT n from Notification n , User u, Client c where n.sender.portfolio.id = :id AND n.id = :id "
				+ "AND n.reciever.portfolio.id = :id")
				.setParameter("id", portfolioId)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllFeedbackMessagessByClient(int clientId) {
		TypedQuery<Feedback> liste = em.createQuery("SELECT Message FROM Feedback f WHERE f.clientId = :IdClient", Feedback.class);
		return (List<String>) liste.setParameter("IdCliend",clientId);
	}

	
	
}
