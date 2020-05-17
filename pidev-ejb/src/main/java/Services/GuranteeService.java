package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Contract;
import Entities.Guarantee;
import Entities.Shares;
import Entities.Bonds;
import Entities.Contract.type_contract;
import interfaces.IgarantieServiceLocal;
import interfaces.IgarantieServiceRemote;



@Stateless
public class GuranteeService implements IgarantieServiceLocal, IgarantieServiceRemote {
	type_contract tc ;
	@PersistenceContext(unitName = "Insurance-ejb")
	EntityManager em;
	
	@Override
	public int addGuarantee(Guarantee gua) {
	em.persist(gua);
		return gua.getGuarantee_id();
	}

	@Override
	public void removeGuarantee(int id) {
		em.remove(em.find(Guarantee.class, id));

	}

	
	@Override
	public Guarantee findGuaranteeById(int id) {
		Guarantee cth = em.find(Guarantee.class, id);

		System.out.println("Out of findContracthById : ");
		return cth;
		
	}

	@Override
	public List<Guarantee> findAllGurantees() {
		List<Guarantee> guaranteelist = em.createQuery("from Guarantee", Guarantee.class).getResultList();
		return guaranteelist;
	}



	@Override
	public List<Guarantee> findAllGuranteesbyclient(int id) {
		int id1 = 2;
		Query q  = em.createQuery("select o from Guarantee o where o.Contract.contract_id = :shares", Guarantee.class);
		List<Guarantee> guaranteelist = q.setParameter("shares",id1).getResultList();
		return guaranteelist;
	}

	@Override
	public List<Guarantee> findAllGuranteesbyContract(int id) {
		
		Query q  = em.createQuery("select o from Guarantee o where o.Contract.contract_id = :shares", Guarantee.class);
		List<Guarantee> guaranteelist = q.setParameter("shares",id).getResultList();
		return guaranteelist;

	}



	@Override
	public List<Guarantee> findAllGuranteesbyContractSharing() {
		Query q  = em.createQuery("select o from Guarantee o where o.Contract.type_contract = :shares", Guarantee.class);
		List<Guarantee> guaranteelist = q.setParameter(tc.Shares.toString(),"shares").getResultList();
		return guaranteelist;
	}

	@Override
	public List<Guarantee> findAllGuranteesbyContractBonding() {
		Query q  = em.createQuery("select o from Guarantee o where o.Contract.type_contract = :bonds", Guarantee.class);
		List<Guarantee> guaranteelist = q.setParameter(tc.Bonds.toString(),"bonds").getResultList();
		return guaranteelist;
	}

	@Override
	public void updateGuarantee(Guarantee cn) {
		// TODO Auto-generated method stub
		
	}


	


	
	

}
