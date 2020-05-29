package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.BankAccount;
import Entities.Client;
import interfaces.ClientAccbankRemote;



@Stateless
//@LocalBean
public class ClientAccbank implements ClientAccbankRemote {
	// imputation-ejb in persistence.xml
		@PersistenceContext(unitName = "PiDbDS")
		EntityManager em;

		@Override
		public void ajouterBankAccount(BankAccount ba) {
			em.persist(ba);	
			
		}

		@Override
		public BankAccount findBankAccountById(int id) {
			System.out.println ("In find BankAccount By Id : ");
			BankAccount ba = em.find(BankAccount.class, id);
			System.out.println ("Out of find BankAccount By Id : ");
			return ba; }

		@Override
		public BankAccount getaccountbankByDepatement(String departement) {
			return (BankAccount) em.createQuery("select d from BankAccount d where d.departement=:departement").setParameter("departement", departement).getResultList().get(0);

		}

		@Override
		public List<BankAccount> findAllBankAccounts() {
			System.out.println("find AllBank Accounts : ");
			List<BankAccount> bas = em.createQuery("from BankAccount",
			BankAccount.class).getResultList();
			System.out.println("Out of findAllBankAccounts  : ");
			return bas;
		}

		@Override
		public void updateAccountBank(BankAccount baNewValues) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<String> getAllDepartementNamesOfAccountBankByClient(int id) {
			TypedQuery<BankAccount> liste = em.createQuery("SELECT departement FROM AccountBank a  WHERE a.id = :id", BankAccount.class);
			return (List<String>) liste.setParameter("id",id);	
		}

		@Override
		public float getRibyClientIdJPQL(int id) {
			TypedQuery<Float> query = em.createQuery(
					  "select c.rib from BankAccount c join c.Client e where e.id=:id", 
					  Float.class);
					  query.setParameter("id", id);
					  return query.getSingleResult();	
		}


		
		
}
