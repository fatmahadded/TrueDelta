package interfaces;

import java.util.List;



import Entities.Client;

public interface IClientInterfaceRemote {

	public Client getClientByEmailAndPassword(String email, String password);

	public void removeClient(int id);

	public void ajouterClient(Client client);

	public void updateClient(Client newClient);

	public Client findClientById(int id);

	public List<Client> getAllClients();
	
	
	public Client getClientrByEmail(String email);
}
