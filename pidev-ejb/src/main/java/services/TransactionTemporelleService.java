package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.AssetManager;
import Entities.Client;
import Entities.TransactionTemporelle;
import interfaces.ITransTempoRemote;

@Stateless
public class TransactionTemporelleService  implements ITransTempoRemote {
	
	@PersistenceContext
	EntityManager em;
	
	private TransactionTemporelle transT;

	@Override
	public void add(TransactionTemporelle entry) {
		em.persist(entry);
		
	}

	@Override
	public List<TransactionTemporelle> findAll() {
		return  em.createQuery("select d from TransactionTemporelle d", TransactionTemporelle.class).getResultList();
	}

	@Override
	public List<TransactionTemporelle> findAllByAssetManagerAndClient(int idManager, int idClient) {
		  TypedQuery<TransactionTemporelle> query= em.createQuery("Select d from TransactionTemporelle d where d.Client.idclient=:idClient And d.AssetManager.idManager=:idManager",TransactionTemporelle.class);
			query.setParameter("idClient",idClient);
			query.setParameter("idManager",idManager);
			System.out.println(query.getResultList());
			return query.getResultList();
	}

	@Override
	public double getClose(int idFirm, Date date) throws ParseException {
		double c = 0;
		try{
		TypedQuery<Double> query= em.createQuery("Select close from Asset d where d.firm.id=:idFirm and DATEDIFF (DATE_FORMAT(d.date,'%d%m%y'),DATE_FORMAT(:date,'%d%m%y'))=0",Double.class);
		query.setParameter("idFirm",idFirm);
		query.setParameter("date",date);
	    c = query.getSingleResult();}
		catch(NoResultException e){
	        System.out.println("no matching");
	      }
		return c;
		
	}

	@Override
	public List<TransactionTemporelle> findGroupByFirm(int id) {
		
		TypedQuery<TransactionTemporelle> query= em.createQuery("Select d from TransactionTemporelle d  where d.Client.idclient=:id Group BY d.title",TransactionTemporelle.class);
		query.setParameter("id",id);
		System.out.println(query.getResultList());
		return query.getResultList();
		
	}

	@Override
	public long nbJours() {
		TypedQuery<Long> query= em.createQuery("Select COUNT(distinct d.date)  from TransactionTemporelle d ",Long.class);
		
		System.out.println(query.getResultList());
		return query.getSingleResult();
	}

	@Override
	public double getSumClose() {
TypedQuery<Double> query= em.createQuery("Select SUM(d.close)  from TransactionTemporelle d ",Double.class);
		
		return query.getSingleResult();
	}

	@Override
	public List<TransactionTemporelle> findOrderByDate() {
		TypedQuery<TransactionTemporelle> query= em.createQuery("Select d from TransactionTemporelle d Order BY DATE_FORMAT(d.date,'%d%m%y') Desc ",TransactionTemporelle.class);
		return query.getResultList();
	}

	@Override
	public List<TransactionTemporelle> findDistinct() {
		TypedQuery<TransactionTemporelle> query= em.createQuery("Select distinct d.title from TransactionTemporelle d",TransactionTemporelle.class);
		return query.getResultList();
	}

	@Override
	public List<TransactionTemporelle> findByMinDate() {
		TypedQuery<TransactionTemporelle> query= em.createQuery("Select d from TransactionTemporelle d Order BY DATE_FORMAT(d.date,'%d%m%y') Asc ",TransactionTemporelle.class);
		return query.getResultList();
	}
		

}
