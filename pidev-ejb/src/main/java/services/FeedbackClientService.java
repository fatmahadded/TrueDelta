package services;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import Entities.AssetManager;
import Entities.Client;
import Entities.Feedback;
import interfaces.FeedbackClient;

@Stateless
//@LocalBean
public class FeedbackClientService implements FeedbackClient {
	//imputation-ejb in persistence.xml
	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;
	
	
	@Override
	public Feedback addFeedback(long idFrom, long idTo, String message) {
		Feedback feedback = new Feedback();
		feedback.setMessage(message);
		AssetManager reciever = em.find(AssetManager.class, idTo);
		Client sender = em.find(Client.class, idFrom);
		feedback.setSender(sender);
		feedback.setReciever(reciever);
		feedback.setDateOfEmission(LocalDateTime.now());
		em.persist(feedback);
		em.flush();
		return em.find(Feedback.class, feedback.getIdFeed());
	}

	@Override
	public boolean removeFeedback(long idfeed) {
		Feedback f = em.find(Feedback.class, idfeed);
		if (f!=null) {
			em.remove(f);
			return true;
		}
		return false;
	}

	@Override
	public Feedback editFeedback(Feedback feedback) {
		em.merge(feedback);
		em.flush();
		return em.find(Feedback.class, feedback.getIdFeed());
	}

	
	@Override
	public Feedback getFeedbackById(long idfeed) {
		return (Feedback) em.createQuery("SELECT f from Feedback f where f.idfeed = "+idfeed).getSingleResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getAll() {
		return em.createQuery("SELECT f from Feedback f ")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getFeedbackHistoryOfClient(long idclient) {
		return em.createQuery("SELECT f from Feedback f where f.reciever.id = :id order by f.dateOfEmission DESC")
				.setParameter("id", idclient).getResultList();
	}

}
