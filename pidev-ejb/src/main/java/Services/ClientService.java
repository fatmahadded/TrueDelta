package services;

import java.util.List;


import javax.ejb.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ejb.Stateless;



import Entities.Client;
import interfaces.IClientInterfaceRemote;
@Stateless
@LocalBean

public class ClientService implements IClientInterfaceRemote {

	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;

	@Override
	public Client getClientrByEmail(String email) {
		return (Client) em.createQuery("select c from Client c where c.email=:email").setParameter("email", email).getResultList().get(0);}

	@Override
	public Client getClientByEmailAndPassword(String email, String password) {
		TypedQuery<Client> query = em.createQuery("SELECT e FROM Client e WHERE e.email=:email AND e.password=:password ", Client.class); 
		query.setParameter("email", email); 
		query.setParameter("password", password); 
		Client client = null; 
		try { client = query.getSingleResult(); }
		catch (Exception e) { System.out.println("Client Inexistant : " + e); }
		return client;
	}

	@Override
	public void removeClient(int id) {
		System.out.println("In remove Client : ");
		em.remove(em.find(Client.class, id));
		System.out.println("Out of remove Client : ");
		
	}

	@Override
	public void ajouterClient(Client client) {
		em.persist(client);		
	}

	@Override
	public void updateClient(Client client) {
		System.out.println("In update User Client : ");
		Client cc = em.find(Client.class,client.getId());
		cc.setFirstname(client.getFirstname());
		cc.setLastname(client.getLastname()); 
		cc.setEmail(client.getEmail()); 
		cc.setPassword(client.getPassword()); 
		cc.setIsActif(client.getIsActif());
		System.out.println("Out of update User Client : ");
		
	}

	@Override
	public Client findClientById(int id) {
		System.out.println("In findClientById : ");
		Client user = em.find(Client.class, id);
		System.out.println("Out of findClientById : ");
		return user;
	}

	@Override
	public List<Client> getAllClients() {
		System.out.println("In findAllClients : ");
		List<Client> clients = em.createQuery("select e from Client e", Client.class).getResultList();
		System.out.println("Out of findAllClients : ");
		return clients;
	}
	
}