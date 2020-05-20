package client.ManagedBeans.customer;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Client;
import services.ClientService;

	@ManagedBean (name="clientBean")
	@SessionScoped
	public class clientBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstname;  private String lastname; private String password; 
	private String email; private Boolean isActif;  
	private Integer clientIdToBeUpdated;
	Client client;

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname =firstname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}


	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Integer getClientIdToBeUpdated() {
		return clientIdToBeUpdated;
	}
	public void setClientIdToBeUpdated(Integer clientIdToBeUpdated) {
		this.clientIdToBeUpdated = clientIdToBeUpdated;
	} 


	@EJB
	ClientService clientService; 

	public void addClient() {
	client= (new Client(lastname, firstname, email, password, isActif));
	clientService.ajouterClient(client);
	}
	
	public List<Client> getClients()
	{	List <Client> clients=clientService.getAllClients();
		return clients;
	}
	public void removeClient(int id) {
		clientService.removeClient(id);
	}
	public void displayClient(Client cc) 
	{
	this.setFirstname(cc.getFirstname());
	this.setLastname(cc.getLastname());
	this.setIsActif(cc.getIsActif()); 
	this.setEmail(cc.getEmail());
	this.setEmail(cc.getEmail());
	this.setPassword(cc.getPassword());
	this.setClientIdToBeUpdated(cc.getId());
	}
	public void updateClient() 
	{ clientService.updateClient(new Client(clientIdToBeUpdated, lastname, firstname, email, password, isActif)); } 
	
	}
	

