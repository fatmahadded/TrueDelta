package interfaces;

import javax.ejb.Remote;


import java.util.List;

import Entities.Client;
import Entities.Portfolio;


@Remote 
public interface ClientPrtServiceRemote {
	//***********client<->portfolio*********************
	public int addClient(Client client);
	public void removeClientById(int idclient);
	public void updateClient (Client clientnewvalues);
	public Client getClientById(int idclient);
	public Client getClientrByUsername(String username);
	public List<Client> findAllClients();
	
	public Client verifyLoginCredentials(String username, String password);

	
	
	public int addPortfolio(Portfolio portfolio);
	public void removePortfolioById(int idcount);
	public void updatePortfolio(Portfolio portfolionewvalues);
	public Portfolio findPortfolioById (int idcount);

	void affecterPortfolioAClient(int idcount, int idclient);
	//pour afficher  le gain du portfolio du client
	public float getGainByClientIdJPQL(int idclient);
	public float getRiskByClientIdJPQL(int idclient);
		
	//au cas + q'un seul portfolio affecté au client
	public List<Integer> getAllPortfoliosIDsByClient(int IdClient);
	public long getNombrePortfolioJPQL();
	public Double getGainMoyenByTransactionId(int IdTransaction);


}
