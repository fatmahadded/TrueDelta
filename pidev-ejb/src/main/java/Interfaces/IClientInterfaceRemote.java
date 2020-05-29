package interfaces;

import java.util.List;



import Entities.Client;

public interface IClientInterfaceRemote {

	public Client getClientByEmailAndPassword(String email, String password);

	public void removeClient(int idclient);

	public int ajouterClient(Client client);

	public int updateClient(Client newClient);

	public Client findClientById(int idclient);

	public List<Client> getAllClients();
	
	
	public Client getClientrByEmail(String email);
}
