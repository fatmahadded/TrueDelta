package client.ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import Entities.User;
import services.UserService;

import Entities.Role;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	@EJB
	UserService userService; 	
	private int id;
	private String username;
	private String password;
	private Role role;
	private User user; 
	private Boolean loggedIn;

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setLogin(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String doLogin() {
		String navigateTo = "null"; 
		user = userService.login(username, password); 
		if (user != null && user.getRole() == Role.Client) {
		//e lien mta3 page nekhdo wakteli bch na3ml page client ta7t el appweb ta7et el pages
			navigateTo = "/pages/clients/clients?faces-redirect=true"; 
		loggedIn = true; }
		else {
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
		return navigateTo; } 
		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true"; }
		}