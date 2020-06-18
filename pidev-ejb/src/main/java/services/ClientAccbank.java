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
public class ClientAccbank implements ClientAccbankRemote {
	// imputation-ejb in persistence.xml
	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;

	@Override
	public int addBankAccount(BankAccount ba) {
		System.out.println(" In addBankAccount: ");
		em.persist(ba);
		System.out.println("Out of addBankAccount " + ba.getIdBankAccount());
		return ba.getIdBankAccount();
	}

	@Override
	public void removeBankAccountById(int idbankAccount) {
		System.out.println(" In removeBankAccountById : ");
		em.remove(em.find(BankAccount.class, idbankAccount));
		System.out.println("Out of removeBankAccountById : ");
	}

	@Override
	public void affecterBankAccountClient(int idbankAccount, int idclient) {
		Client clientManagedEntity = em.find(Client.class, idclient);
		BankAccount baManagedEntity = em.find(BankAccount.class, idbankAccount);

		baManagedEntity.setClients(clientManagedEntity);

	}

	@Override
	public List<Integer> getAllBankAccountIDsByClient(int idclient) {
		Client clientManagedEntity = em.find(Client.class, idclient);
		List<Integer> BankAccountIDs = new ArrayList<>();
		for (BankAccount ba : clientManagedEntity.getBankAccounts()) {
			BankAccountIDs.add(ba.getIdBankAccount());
		}

		return BankAccountIDs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllDepartementNamesOfAccountBankByClient(int idclient) {

		TypedQuery<BankAccount> liste = em
				.createQuery("SELECT departement FROM AccountBank a  WHERE a.idclient = :idclient", BankAccount.class);
		return (List<String>) liste.setParameter("idclient", idclient);
	}

	@Override
	public String getBankAccountBankDepartmentById(int idclient) {
		BankAccount ba = em.find(BankAccount.class, idclient);
		return "le departement du compte bancaire est: " + ba.getDepartement();
	}

	@Override
	public float getRibyClientIdJPQL(int idclient) {
		TypedQuery<Float> query = em
				.createQuery("select c.rib from BankAccount c join c.Client e where e.idclient=:idclient", Float.class);
		query.setParameter("idclient", idclient);
		return query.getSingleResult();
	}

	@Override
	public BankAccount findBankAccountById(int idbankAccount) {
		System.out.println("InfindBankAccountById : ");
		BankAccount ba = em.find(BankAccount.class, idbankAccount);
		System.out.println("Out of findBankAccountById : ");
		return ba;
	}

}
