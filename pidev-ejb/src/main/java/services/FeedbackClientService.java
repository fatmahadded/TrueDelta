package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import Entities.Feedback;
import Entities.Portfolio;
import interfaces.FeedbackClient;

public class FeedbackClientService implements FeedbackClient {
	@PersistenceContext
	EntityManager em;

	@Override
	public int addFeedback(int idportfolio, Feedback feedback) {
		Portfolio p = em.find(Portfolio.class, idportfolio);
		p.setFeedbacks(new HashSet<Feedback>());
		p.addFeedBack(feedback);
		feedback.setPortfolios(p);
		em.persist(feedback);
		return feedback.getId();}

	@Override
	public int updateFeedback(Feedback feed) {
		Feedback oldF = em.find(Feedback.class, feed.getId());
		Portfolio p = em.find(Portfolio.class, oldF.getPortfolios().getId());
		feed.setPortfolios(p);
		em.merge(feed);
		return feed.getId();

	}

	@Override
	public Feedback getFeedback(int idfeedback) {
		Feedback feed = em.find(Feedback.class, idfeedback);
		return feed;

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getPortfolioFeedbacks(int idportfolio) {
		Query feedbacks = em.createQuery("select f from Feedback f where f.Portfolio.id = :idportfolio").setParameter("portfolio_id",idportfolio);
		return feedbacks.getResultList();

	}

	@Override
	public void ajouterFeedback(Feedback feedback) {
		em.persist(feedback);
		
		//return feedback.getId();
	}

}
