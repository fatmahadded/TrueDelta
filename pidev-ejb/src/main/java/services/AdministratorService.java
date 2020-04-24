package services;

import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Bank;
import Entities.BankAccount;
import interfaces.AdministratorServiceLocal;
import interfaces.AdministratorServiceRemote;

@Stateless
public class AdministratorService implements AdministratorServiceRemote, AdministratorServiceLocal {
	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;
	@Override
	public int ajouterBank(Bank bank) {
		em.persist(bank);
		return bank.getId();
		}

	@Override
	public void supprimerBank(int idBank) {
		// TODO Auto-generated method stub
		Bank bank = em.find(Bank.class, idBank);
		em.remove(bank);
	}
	
	@Override
	public BankAccount findCountbyCount(int IdBank , String NumCount , double montant) {
		TypedQuery<BankAccount> query=
				em.createQuery("SELECT B FROM BankAccount B where B.IdBankAccount:= IdBank , B.RIB:=NumCount and B.montant:=montant ",BankAccount.class);
		query.setParameter("IdBank", IdBank);
		query.setParameter("NumCount", NumCount);
		query.setParameter("montant", montant);
		return query. getSingleResult();
					  
		}
}
