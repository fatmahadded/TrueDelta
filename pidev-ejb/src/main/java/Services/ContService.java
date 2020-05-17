package services;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Contract;
import Entities.Membre;
import Entities.Role;
import Entities.Ensemble;


import interfaces.contRemote;



@Stateless
@LocalBean
public class ContService implements contRemote {

	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;

	@Override
	public int ajouterMembre(Membre membre) {
		em.persist(membre);
		return membre.getIdMembre();
	}

	@Override
	public void ajouterContractMembre(Contract contract, String loginClient, String loginAssetManager) {
		Membre client = em.createQuery("select e from Membre e where e.login=:login", Membre.class).setParameter("login", loginClient).getSingleResult();
		Membre assetmanager = em.createQuery("select e from Membre e where e.login=:login", Membre.class).setParameter("login", loginAssetManager).getSingleResult();
		contract.setAssetManager(assetmanager);
		contract.setClient(client);
		em.persist(contract);

	}

	@Override
	public void modifierEtat(int idClient, String titreContract) {
		Membre e=em.find(Membre.class, idClient);
		for(Contract s:e.getClientContracts()) {
			if(s.getTitre().equals(titreContract))
				s.setEtat(true);
		}

	}

	@Override
	public int affecterEtoile(int idMembre) {
		Membre e=em.find(Membre.class, idMembre);
		if(e.getRole().equals(Role.Client)) {
			 e.setNbStars(e.getClientContracts().size());
		return e.getNbStars();
		}
		else {
			 e.setNbStars(e.getAssetManagerContracts().size());
				return e.getNbStars();

		}
	}

	@Override
	public List<Contract> chercherContractMotCle(String motC) {
		List<Contract> contracts = em.createQuery("select e from Contract e", Contract.class).getResultList();
		List<Contract> l=new ArrayList<>();
		for(Contract s:contracts) {
			if(s.getMotcle().contains(motC))
				l.add(s);
		}
		return l;
	}

	@Override
	public int ajouterEnsemeble(String nomBase, List<String> motsCle) {
		Ensemble c=new Ensemble(nomBase, Date.valueOf(LocalDate.now()), motsCle);
		em.persist(c);
		return c.getIdKBase();
	}

	@Override
	public void affecterContractsEnsmeble(int idConnaissance) {
		Ensemble c=em.find(Ensemble.class, idConnaissance);
		for(String s:c.getMotcle()) {
			List<Contract> li=chercherContractMotCle(s);
			for(Contract su:li) {
				if(su.isEtat()==true)
					su.setEnsemble(c);
			}
			
		}
		

}

	@Override
	public Membre getUserBylogin(String login, String password) {
		TypedQuery<Membre> query = em
				.createQuery("SELECT e FROM Membre e WHERE e.login=:login AND e.password=:password ", Membre.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		Membre user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return user;
	}

	
	}
