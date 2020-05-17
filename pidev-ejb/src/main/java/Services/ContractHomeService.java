package services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Client;
import Entities.Contract;
import Entities.Guarantee;

import interfaces.IContracthomeServiceRemote;




@Stateless
public class ContractHomeService implements  IContracthomeServiceRemote {
	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;
	
	

	@Override
	public int addContracth(Contract cn) {
		em.persist(cn);
		return cn.getContract_id();
	}

	@Override
	public void removeContracth(int id) {
		System.out.println (" In remove Contract ById : ");
		em.remove(em.find(Contract.class, id));
		System.out.println("Out of remove Contract: ");

	}

	@Override
	public int updateContracth(Contract cn) {
		Contract oldP = em.find(Contract.class, cn.getContract_id());
		Client client = em.find(Client.class, oldP.getClient().getId());
		cn.setClient(client);
		em.merge( cn);
		return cn.getContract_id();
	}

	@Override
	public Contract findContractById(int id) {
		System.out.println("In find Contract By Id : ");
		Contract cth = em.find(Contract.class, id);

		System.out.println("Out of find Contract By Id : ");
		return cth;
	}

	@Override
	public List<Contract> findAllContracths() {
		System.out.println("In find All Contracts : ");
		List<Contract> Contracth = em.createQuery("from Contract", Contract.class).getResultList();
		
		System.out.println("Out of find All Contracts + : ");
		return Contracth;
	}

	@Override
	public List<Contract> findAllContractsbyclient(int id) {
		System.out.println("In find All Contracts: ");
		Query q =em.createNativeQuery("SELECT * FROM contract a where a.Client_User_ID = :id");
		
		q.setParameter("id", id);
		List<Contract> Contracth  =  q.getResultList();
		
		System.out.println("Out of find All Contracts : ");
		return Contracth ;
	}

	@Override
	public long getNombreContractJPQL() {
		TypedQuery<Long> query = em.createQuery("select count(p) from Contract c", Long.class);
		return query.getSingleResult();
	}

	@Override
	public float getPrimeByClientIdJPQL(int id) {
		TypedQuery<Float> query = em.createQuery(
				  "select c.prime from Contract c join c.Client e where e.id=:id", 
				  Float.class);
				  query.setParameter("id", id);
				  return query.getSingleResult();	
	}

	@Override
	public float getCommisionByClientIdJPQL(int id) {
		TypedQuery<Float> query = em.createQuery(
				  "select c.commission from Contract c join c.Client e where e.id=:id", 
				  Float.class);
				  query.setParameter("id", id);
				  return query.getSingleResult();
	}

	@Override
	public long calculerNbrTitres(int idClient) {
		TypedQuery<Long> query1 = em.createQuery(
				"SELECT SUM(bondsnbr) FROM Bonds WHERE Bonds.id=:id_bonds"  
				, Long.class);  
		query1.setParameter("id_bonds", idClient); 	
		long bondsnbr = query1.getSingleResult(); 

		TypedQuery<Long> query2 = em.createQuery(
				"SELECT SUM(sharesnbr) FROM Shares WHERE shares.id=:id_shares" 
				, Long.class);  
		query2.setParameter("id_shares", idClient); 	
		long sharesnbr = query2.getSingleResult(); 		

		return bondsnbr + sharesnbr;
	}

	


}
