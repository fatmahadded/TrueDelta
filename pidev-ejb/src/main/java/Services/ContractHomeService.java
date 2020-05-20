package services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
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
@LocalBean
public class ContractHomeService implements  IContracthomeServiceRemote {
	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;

	@Override
	public void ajouterContract(Contract contract) {
		em.persist(contract);
		
	}

	@Override
	public void affecterContratAClient(int idcontract, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContract(int idcontract) {
		System.out.println("In remove Contract between Client and AM : ");
		em.remove(em.find(Contract.class, idcontract));
		System.out.println("Out of remove Contract: ");
		
	}

	@Override
	public void updateContract(Contract contract) {
		System.out.println("In update Contract Between Client and AssetM : ");
		Contract cnt = em.find(Contract.class,contract.getContract_id());
		cnt.setMNT(contract.getMNT()); 
		cnt.setCommission(contract.getCommission()); 
		cnt.setPrime(contract.getPrime());
		cnt.setTitre_nbr(contract.getTitre_nbr());
		System.out.println("Out of update : ");
		
	}

	@Override
	public Contract findContractById(int idcontract) {
		System.out.println("In findContractById : ");
		Contract ccn = em.find(Contract.class, idcontract);
		System.out.println("Out of findContractById : ");
		return ccn;
	}

	@Override
	public List<Contract> findAllContracths() {
		System.out.println("In findAllContracts : ");
		List<Contract> contracts = em.createQuery("select c from Contract c", Contract.class).getResultList();
		System.out.println("Out of findAllContracts : ");
		return contracts;
	}

	@Override
	public List<Contract> findAllContractsbyclient(int id) {
		System.out.println("In find All Contracts: ");
		Query q =em.createNativeQuery("SELECT * FROM Contract a where a.Client_User_ID = :id");
		
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
	
	



}
