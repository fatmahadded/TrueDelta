package client.ManagedBeans.acceuilClient;


import java.io.Serializable;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import Entities.Client;
import Entities.BankAccount;
import services.ClientAccbank ;
import services.ClientService ;

@ManagedBean 
@SessionScoped
public class AcceuilClientService implements Serializable {
	private static final long serialVersionUID = 1L;
	private Client client; 
	private BankAccount ba; 	
	
	@EJB
	ClientAccbank cab;
	ClientService cs;
	
	public AcceuilClientService() {}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}


	public BankAccount getBankAccount() {
		return ba;
	}


	public void setBankAccount(BankAccount ba) {
		this.ba= ba;
	}
	
	public ClientAccbank  getClientAccbank () {
		return cab ;
	}


	public void setClientAccbank(ClientAccbank cab) {
		this.cab= cab;
	}
	
	public ClientService  getClientService () {
		return cs ;
	}


	public void setClientService(ClientService cs) {
		this.cs= cs;
	}


}