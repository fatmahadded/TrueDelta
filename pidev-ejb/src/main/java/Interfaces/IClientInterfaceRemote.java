package interfaces;

import java.util.List;




import Entities.Client;

public interface IClientInterfaceRemote {

	public void addClient(Client client);
	public void removeClientById(int clientId); 
	public void updateClient(Client clientnewvalues) ;
	
	public Client getClientById(int clientId);
	public Client getClientrByUsername(String username); 
	public Client getUserByUsernameAndPassword(String username, String password) ;

	public List<Client> findAllClients();

	public Client verifyLoginClient(String username, String password);
}
