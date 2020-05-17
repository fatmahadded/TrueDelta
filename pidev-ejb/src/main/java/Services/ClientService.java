package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ejb.Stateless;



import Entities.Client;
import interfaces.IClientInterfaceRemote;
@Stateless
public class ClientService implements IClientInterfaceRemote {

	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;
	@Override
	public void addClient(Client client) {
		em.persist(client);	}
	

	@Override
	public void removeClientById(int clientId) {
		System.out.println ("  In remove Client by Id : ");
		em.remove(em.find(Client.class, clientId));
		System.out.println (" Out Of remove Client By Id : ");	
		
	}

	@Override
	public void updateClient(Client clientnewvalues) {
		System.out.println("In update Client" );
		Client client = em.find(Client.class, clientnewvalues.getId());
		client.setUsername(clientnewvalues.getUsername());
		client.setImage(clientnewvalues.getImage());
		System.out.println("Out of update Client :");
	}

	@Override
	public Client getClientById(int clientId) {
		System.out.println (" In find Client By Id : ");
		 Client client = em.find(Client.class, clientId);
		 System.out.println ("Out of find Client By Id : ");
		 return client;	
	}

	@Override
	public Client getClientrByUsername(String username) {
		return (Client) em.createQuery("select c from Client c where c.username=:username").setParameter("username", username).getResultList().get(0);
	}

	@Override
	public List<Client> findAllClients() {
		System.out.println("In findAllClients: ");
		List<Client> clients = em.createQuery("from Client",Client.class).getResultList();
		System.out.println("Out findAllClients: ");
		return clients;
	}
	@Override
	public Client getUserByUsernameAndPassword(String username, String password) {
		TypedQuery<Client> query = 
				em.createQuery("select c from Client c WHERE c.username=:username and c.password=:password ", Client.class); 
		query.setParameter("nom", username); 
		query.setParameter("pwd", password); 
		Client client = null; 
		try { client = query.getSingleResult(); }
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return client;
	}

	@Override
	public Client verifyLoginClient(String username, String password) {
		System.out.println("from : "+username + " "+password);
		Query query = em.createQuery("select c from Client c where c.username = :username AND c.password = :password")
				.setParameter("username",username).setParameter("password", password);
		if(!query.getResultList().isEmpty()) {
			
			Client client = (Client) query.getResultList().get(0);
			System.out.println("from ejb, client found, authenticating client with id :"+client. getId());
			return client;
		}
		System.out.println("client not found !");
		return null;
	}
}