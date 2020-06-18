package services;

import java.io.IOException;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Client;
import Entities.Portfolio;
import interfaces.ClientPrtServiceRemote;

@Stateless
public class ClientPrtService implements ClientPrtServiceRemote {
	// imputation-ejb in persistence.xml
	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;

	// ***********client*************************

	@Override
	public Client verifyLoginCredentials(String username, String password) {
		System.out.println("from ejb : " + username + " " + password);
		Query query = em.createQuery("select c from Client c where c.username = :username AND c.password = :password")
				.setParameter("username", username).setParameter("password", password);
		if (!query.getResultList().isEmpty()) {

			Client client = (Client) query.getResultList().get(0);
			System.out.println("from ejb, client found, authenticating client with id :" + client.getIdClient());
			return client;
		}
		System.out.println("client not found !");
		return null;
	}

	@Override
	public int addClient(Client client) {
		System.out.println(" In addClient: ");
		em.persist(client);
		System.out.println(" Out Of addClient " + client.getIdClient());
		/*
		 * try { EmailService email = new EmailService();
		 * email.sendEmail("yassine.chatbri@esprit.tn", "test",
		 * "yassine.chatbri@esprit.tn", "Get shwity"); } catch (IOException |
		 * URISyntaxException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		return client.getIdClient();
	}

	@Override
	public void removeClientById(int idclient) {
		System.out.println("  In removeClientById : ");
		em.remove(em.find(Client.class, idclient));
		System.out.println(" Out Of removeClientById : ");
	}

	@Override
	public void updateClient(Client clientnewvalues) {
		System.out.println("In updateClient");
		Client client = em.find(Client.class, clientnewvalues.getIdClient());
		client.setUsername(clientnewvalues.getUsername());
		client.setLastname(clientnewvalues.getLastname());
		client.setPassword(clientnewvalues.getPassword());
		client.setImage(clientnewvalues.getImage());
		System.out.println("Out of updateClient :");

	}

	@Override
	public Client getClientById(int idclient) {
		System.out.println(" In getClientById : ");
		Client client = em.find(Client.class, idclient);
		System.out.println("Out of getClientById : ");
		return client;
	}

	@Override
	public Client getClientrByUsername(String username) {
		return (Client) em.createQuery("select c from Client c where c.username=:us").setParameter("us", username)
				.getResultList().get(0);
	}

	@Override
	public List<Client> findAllClients() {
		System.out.println("In findALLUSERS : ");
		List<Client> clients = em.createQuery("from Client", Client.class).getResultList();
		System.out.println("Out findALLUSERS : ");
		return clients;
	}

//************************portfolio*******************************************
	@Override
	public int addPortfolio(Portfolio portfolio) {
		System.out.println(" addPortfolio: ");
		em.persist(portfolio);
		System.out.println("addPortfolio " + portfolio.getId());
		return portfolio.getId();
	}

	@Override
	public void removePortfolioById(int idcount) {
		System.out.println(" In removePortfolioById : ");
		em.remove(em.find(Client.class, idcount));
		System.out.println("Out of removePortfolioById : ");
	}

	@Override
	public void updatePortfolio(Portfolio portfolionewvalues) {
		System.out.println("In updatePortfolio");
		Portfolio portfolio = em.find(Portfolio.class, portfolionewvalues.getId());
		portfolio.setAmount(portfolionewvalues.getAmount());
		portfolio.setGain(portfolionewvalues.getGain());
		portfolio.setRisk(portfolionewvalues.getRisk());

		System.out.println("Out of updatePortfolio :");
	}

	@Override
	public Portfolio findPortfolioById(int idcount) {
		System.out.println("In findPortfolioById : ");
		Portfolio portfolio = em.find(Portfolio.class, idcount);
		System.out.println("Out of findPortfolioById : ");
		return portfolio;
	}
	// ************************portfolio<-->client*******************************************

	@Override
	public void affecterPortfolioAClient(int idcount, int idclient) {

		Client clientManagedEntity = em.find(Client.class, idclient);
		Portfolio portfolioManagedEntity = em.find(Portfolio.class, idcount);

		portfolioManagedEntity.setClient(clientManagedEntity);
	}

	@Override
	public long getNombrePortfolioJPQL() {
		TypedQuery<Long> query = em.createQuery("select count(p) from Portfolio p", Long.class);
		return query.getSingleResult();
	}

	@Override
	public float getGainByClientIdJPQL(int idclient) {
		TypedQuery<Float> query = em
				.createQuery("select c.gain from Portfolio c join c.Client e where e.idclient=:idclient", Float.class);
		query.setParameter("idclient", idclient);
		return query.getSingleResult();
	}

	@Override
	public float getRiskByClientIdJPQL(int idclient) {
		TypedQuery<Float> query = em
				.createQuery("select c.risk from Portfolio c join c.Client e where e.idclient=:idclient", Float.class);
		query.setParameter("idclient", idclient);
		return query.getSingleResult();
	}

	// en cas +un seul portfolio est affecter a client

	@Override
	public List<Integer> getAllPortfoliosIDsByClient(int idclient) {
		Client clientManagedEntity = em.find(Client.class, idclient);
		List<Integer> PortfoliosIDs = new ArrayList<>();
		for (Portfolio portfolio : clientManagedEntity.getPortfolios()) {
			PortfoliosIDs.add(portfolio.getId());
		}

		return PortfoliosIDs;
	}

	@Override
	public Double getGainMoyenByTransactionId(int IdTransaction) {
		TypedQuery<Double> query = em.createQuery("Select " + "DISTINCT AVG(portf.gain) from Portfolio portf "
				+ "join portf.Client cl " + "join cl.Transaction trans " + "where trans.id=:IdTransaction",
				Double.class);

		query.setParameter("IdTransaction", IdTransaction);
		return query.getSingleResult();
	}

}
