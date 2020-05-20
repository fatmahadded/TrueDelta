package client.ManagedBeans.customer;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import Entities.Client;
import services.ClientService;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String login; 
private String password; 
private Client client; 
private Boolean loggedIn;
private Boolean isActif;  

public Boolean getIsActif() {
	return isActif;
}
public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
}

@EJB
ClientService clientService; 

public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Boolean getLoggedIn() {
	return loggedIn;
}
public void setLoggedIn(Boolean loggedIn) {
	this.loggedIn = loggedIn;
}
public String doLogin() {
String navigateTo = "null"; 
client = clientService.getClientByEmailAndPassword(login, password); 
if (client != null ) {
navigateTo = "/pages/admin/clients/pagegarde?faces-redirect=true"; 
loggedIn = true; }
else {
FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
return navigateTo; } 
public String doLogout() {
FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
return "/login?faces-redirect=true"; }
}













