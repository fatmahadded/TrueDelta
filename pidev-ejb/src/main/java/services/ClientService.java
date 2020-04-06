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
import Entities.Portfolio;
import interfaces.ClientServiceRemote;


@Stateless
@LocalBean
public class ClientService implements ClientServiceRemote {
	// imputation-ejb in persistence.xml
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
	
	
	@Override
	public int addClient(Client client) {
		System.out.println(" In addClient: ");
		em.persist(client);
		System.out.println ("Out of addClient "+client.getId());
		return client.getId();
	}

	@Override
	public void removeClientById(int IdClient) {
		System.out.println (" In removeClientById : ");
		em.remove(em.find(Client.class, IdClient));
		System.out.println ("Out of removeClientById : ");

	}
//reccuperer la liste des portfolios
@Override
	public Client getClientById(int IdClient) {
	System.out.println (" In getClientById : ");
	 Client client = em.find(Client.class, IdClient);
	 System.out.println ("Out of getClientById : ");
	 return client;
      }
//update user name of customer

@Override
public void updateClient(Client clientnewvalues) {
	System.out.println("In updateClient" );
	Client client = em.find(Client.class, clientnewvalues.getId());
	client.setUsername(clientnewvalues.getUsername());
	System.out.println("Out of updateClient :");
	
}


	@Override
	public int addPortfolio(Portfolio portfolio) {
		System.out.println(" In addPortfolio: ");
		em.persist(portfolio);
		System.out.println ("Out of addPortfolio "+portfolio.getId());
		return portfolio.getId();

		
	}

	@Override
	public void removePortfolioById(int IDCount) {
		System.out.println (" In removePortfolioById : ");
		em.remove(em.find(Client.class, IDCount));
		System.out.println ("Out of removePortfolioById : ");

	}
	//update client risk gain montant  du contract
	@Override
	public void updatePortfolio(Portfolio portfolionewvalues) {
		System.out.println("In updatePortfolio" );
		Portfolio portfolio = em.find(Portfolio.class, portfolionewvalues.getId());
		portfolio.setAmount(portfolionewvalues.getAmount());
		portfolio.setGain(portfolionewvalues.getGain());
		portfolio.setRisk(portfolionewvalues.getRisk());

		System.out.println("Out of updatePortfolio :");
	}

	@Override
	public Portfolio findPortfolioById(int Id) {
		System.out.println ("In findPortfolioById : ");
		Portfolio portfolio = em.find(Portfolio.class, Id);
		System.out.println ("Out of findPortfolioById : ");
		return portfolio;
	}


	
	@Override
	public long getNombrePortfolioJPQL() {
		TypedQuery<Long> query = em.createQuery("select count(p) from Portfolio p", Long.class);
		return query.getSingleResult();
	}

	
	@Override
	public void affecterPortfolioAClient(int IDCount, int IdClient) {
		
				Client clientManagedEntity = em.find(Client.class, IdClient);
				Portfolio portfolioManagedEntity = em.find(Portfolio.class, IDCount);

				portfolioManagedEntity.setClient(clientManagedEntity);
				
	}

	//@Override
	//public void desaffecterPorfolioDuClient(int IDCount, int IdClient) {
       
		//Client client = em.find(Client.class,IdClient);
		//int portfolioNb = client.getPortfolios().size();
		//for(int index = 0; index < portfolioNb; index++){
			//if(client.getPortfolios().get(index).getId() ==IDCount){
			//	client.getPortfolios().remove(index);
				//break;}}
	//}
	@Override
	public float geGainByClientIdJPQL(int IdClient) {
		TypedQuery<Float> query = em.createQuery(
				  "select c.gain from Portfolio c join c.Client e where e.id=:IdClient", 
				  Float.class);
				  query.setParameter("IdClient", IdClient);
				  return query.getSingleResult();	}

	//si on a plusieur transaction dans un seul contrat 
	@Override
	public Double getGainMoyenByTransactionId(int IdTransaction) {
		TypedQuery<Double> query = em.createQuery("Select "
				+ "DISTINCT AVG(portf.gain) from Portfolio portf "
				+ "join portf.Client cl "
				+ "join cl.Transaction trans "
				+ "where trans.id=:IdTransaction", Double.class);
		
		query.setParameter("IdTransaction", IdTransaction);		
		return query.getSingleResult();
	}


	



	@Override
	public List<Integer> getAllPortfoliosIDsByClient(int IdClient) {
		Client clientManagedEntity = em.find(Client.class, IdClient);
		List<Integer> PortfoliosIDs = new ArrayList<>();
		for(Portfolio portfolio : clientManagedEntity.getPortfolios()){
			PortfoliosIDs.add(portfolio.getId());
		}
		
		return PortfoliosIDs;
	}
	


	

	@Override
	public int addBankAccount(BankAccount ba) {
		System.out.println(" In addBankAccount: ");
		em.persist(ba);
		System.out.println ("Out of addBankAccount "+ba.getId());
		return ba.getId();
	}

	@Override
	public void removeBankAccountById(int IdBankAccount) {
		
		System.out.println (" In removeBankAccountById : ");
		em.remove(em.find(BankAccount.class, IdBankAccount));
		System.out.println ("Out of removeBankAccountById : ");
}

	@Override
	public void affecterBankAccountClient(int IdBankAccount, int IdClient) {
		
		Client clientManagedEntity = em.find(Client.class, IdClient);
		BankAccount baManagedEntity = em.find(BankAccount.class, IdBankAccount);

		baManagedEntity.setClients(clientManagedEntity);
		
	}

	@Override
	public List<Integer> getAllBankAccountIDsByClient(int IdClient) {
		Client clientManagedEntity = em.find(Client.class, IdClient);
		List<Integer> BankAccountIDs = new ArrayList<>();
		for(BankAccount ba : clientManagedEntity.getBankAccounts()){
			BankAccountIDs.add(ba.getId());
		}
		
		return BankAccountIDs;
	}


	
	

	
	

	
}
