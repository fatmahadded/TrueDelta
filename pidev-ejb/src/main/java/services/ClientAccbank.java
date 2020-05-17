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
		public void addBankAccount(BankAccount ba) {
			
			em.persist(ba);	}

		@Override
		public void removeBankAccountById(int idba) {
			System.out.println (" In remove BankAccount By Id : ");
			em.remove(em.find(BankAccount.class, idba));
			System.out.println ("Out of remove Bank Account By Id : ");
			
		}

		@Override
		public BankAccount findBankAccountById(int idba) {
			System.out.println ("In find BankAccount By Id : ");
			BankAccount ba = em.find(BankAccount.class, idba);
			System.out.println ("Out of find BankAccount By Id : ");
			return ba; }

		//@Override
		//public void affecterBankAccountClient(int idba, int idclient) {
			//Client clientManagedEntity = em.find(Client.class, idclient);
			//BankAccount baManagedEntity = em.find(BankAccount.class, idba);

			//baManagedEntity.setClients(clientManagedEntity);
		//}

		@Override
		public List<BankAccount> findAllBankAccounts() {
			System.out.println("find AllBank Accounts : ");
			List<BankAccount> bas = em.createQuery("from BankAccount",
			BankAccount.class).getResultList();
			System.out.println("Out of findAllBankAccounts  : ");
			return bas;
		}

		@Override
		public void updateAccountBank(BankAccount userNewValues) {
			System.out.println("In updateAccountBank : ");
			BankAccount ba = em.find(BankAccount.class, userNewValues.getId());
			ba.setMontant(userNewValues.getMontant());
			System.out.println("Out of updateAccountBank: ");
			
		}

		@Override
		public BankAccount getaccountbankByDepatement(String departement) {

			
			return (BankAccount) em.createQuery("select d from BankAccountc where d.departement=:departement").setParameter("departement", departement).getResultList().get(0);
		}

		@Override
		public List<String> getAllDepartementNamesOfAccountBankByClient(int id) {
			TypedQuery<BankAccount> liste = em.createQuery("SELECT departement FROM AccountBank a  WHERE a.idclient = :idclient", BankAccount.class);
			return (List<String>) liste.setParameter("idclient",id);	
		}

		@Override
		public float getRibyClientIdJPQL(int id) {
			TypedQuery<Float> query = em.createQuery(
					  "select c.rib from BankAccount c join c.Client e where e.idclient=:idclient", 
					  Float.class);
					  query.setParameter("idclient", id);
					  return query.getSingleResult();	
		}

		
		
}
