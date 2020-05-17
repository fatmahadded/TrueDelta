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
	public int addFeedback(int portfolioId, Feedback feed) {
		Portfolio p = em.find(Portfolio.class, portfolioId);
		p.setFeedbacks(new HashSet<Feedback>());
		p.addFeedBack(feed);
		feed.setPortfolios(p);
		em.persist(feed);
		return feed.getId();

	}

	@Override
	public int updateFeedback(Feedback feed) {
		Feedback oldF = em.find(Feedback.class, feed.getId());
		Portfolio p = em.find(Portfolio.class, oldF.getPortfolios().getId());
		feed.setPortfolios(p);
		em.merge(feed);
		return feed.getId();

	}

	@Override
	public Feedback getFeedback(int feedId) {
		Feedback feed = em.find(Feedback.class, feedId);
		return feed;

	}

	
	@Override
	public List<Feedback> getPortfolioFeedbacks(int portfolioId) {
		Query feedbacks = em.createQuery("select f from Feedback f where f.Portfolio.id = :portfolioId").setParameter("portfolio_id",portfolioId);
		return feedbacks.getResultList();

	}

}
