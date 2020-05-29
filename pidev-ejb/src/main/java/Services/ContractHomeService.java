package services;

import java.util.ArrayList;
import java.util.Collection;
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

import interfaces.IContracthomeServiceRemote;

@Stateless
@LocalBean
public class ContractHomeService implements  IContracthomeServiceRemote {
	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;

	@Override
	public int ajouterContract(Contract contract) {
		em.persist(contract);
		
			return contract.getContract_id();
		}

		
	

	@Override
	public void affecterContratAClient(int idcontract, int idclient) {
		Client clientManagedEntity =em.find(Client.class, idclient);
		Contract contractManagedEntity = em.find(Contract.class, idcontract);
		contractManagedEntity.setClient(clientManagedEntity);
	
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
		cnt.setGain(contract.getGain()); 

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
	public List<Contract> findAllContractsbyclient(int idclient) {
		System.out.println("In find All Contracts: ");
		Query q =em.createNativeQuery("SELECT * FROM Contract a where a.idclient = :idclient");
		
		q.setParameter("idclient", idclient);
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
	public float getPrimeByClientIdJPQL(int idclient) {
		TypedQuery<Float> query = em.createQuery(
				  "select c.prime from Contract c join c.Client e where e.idclient=:idclient", 
				  Float.class);
				  query.setParameter("idclient", idclient);
				  return query.getSingleResult();	
	}

	
	
	



}
