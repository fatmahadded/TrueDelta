package services;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Entities.Portfolio;
import interfaces.IPortfolioRemoteService;
import java.util.Comparator;

@Stateless
public class PortfolioService implements IPortfolioRemoteService {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public int AddPortfolio(Portfolio P) {
		em.persist(P);
		return P.getId();
	}

	@Override
	public void DeletePortfolio(int IdPortfolio) {
		Portfolio p = new Portfolio();
		p=em.find(Portfolio.class, IdPortfolio);
		em.remove(p);
	}

	@Override
	public Portfolio DisplayPortfolio(int IdPortfolio) {
		Portfolio p = new Portfolio();
		p=em.find(Portfolio.class, IdPortfolio);
		return p;
	}

	@Override
	public List<Portfolio> DisplayPortfolios() {
		Query query=em.createQuery("select p from Portfolio p");
		return query.getResultList();
	}

	@Override
	public void EditPortfolio(Portfolio p) {
		em.merge(p);

	}
	
	//@Override
	////public Portfolio PortfolioOptimale() {
	//<Portfolio> ls = DisplayPortfolios();
		//Portfolio porfolio =  Collections.max(ls, Comparator.comparing(p -> p.getRS()));
        
     //   return porfolio;
	//}

}