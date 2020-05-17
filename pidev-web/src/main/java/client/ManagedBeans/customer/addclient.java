package client.ManagedBeans.customer;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Client;
import services.ClientService;

@ManagedBean (name="addclientBean")
@SessionScoped
public class addclient implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id; 
	
	private String username;

	private String firstname;
	
	private String lastname;
	
	private String password;
	
	private String image;
	private Integer clientIdToBeUpdated;
	 
	
//********	
	public int getId() {
		return id;
	}
	public void setId( int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService  clientService) {
		this.clientService =clientService;
	}
	
    public Integer getClientIdToBeUpdated() {
		return clientIdToBeUpdated;
	}
	public void setClientIdToBeUpdated(Integer clientIdToBeUpdated) {
		this.clientIdToBeUpdated = clientIdToBeUpdated;
	} 
	//*******
	Client client;
	@EJB
	ClientService clientService; 
	//******
  
	public void addClient() {
			String navigateTo = "null";
			navigateTo = "/pages/clients/addclient?faces-redirect=true";
			client= (new Client(username, firstname,lastname, password, image));
		clientService. addClient(client);
		}
		
		public List<Client> findAllClients()
		{	String navigateTo = "null";
		navigateTo = "/pages/clients/addclient?faces-redirect=true";
			List <Client> clients=clientService.findAllClients();
			return clients;
		}
		public void removeClientById(int id) {
			String navigateTo = "null";
			navigateTo = "/pages/clients/addclient?faces-redirect=true";
			clientService.removeClientById(id);
		}
		

		public void displayClient(Client client) 
		{
			String navigateTo = "null";
			navigateTo = "/pages/clients/addclient?faces-redirect=true";
			this.setFirstname(client.getFirstname());
			this.setLastname(client.getLastname());
			this.setPassword(client.getPassword());
		    this.setUsername(client.getUsername());
		    this.setImage(client.getImage());
		    this.setClientIdToBeUpdated(client.getId());
		}
		public void updateClient() {
			String navigateTo = "null";
			navigateTo = "/pages/clients/addclient?faces-redirect=true";
			clientService.updateClient(new Client(clientIdToBeUpdated, username,image)); } 
		
		}
		