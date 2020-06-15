package ManagedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import Entities.Role;
import Entities.User;
import services.AdministratorService;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private User user;
	private Boolean loggedIn;
	private String mot;

	
	

	@EJB
	AdministratorService AdminService;

	/*
	 * public String doLogin() { String navigateTo = "null"; user =
	 * AdminService.getUserByEmailAndPassword(login, password); if (user != null &&
	 * user.getRole().equals(Role.Administrateur)) { navigateTo =
	 * "/pages/admin/GestionBank"; loggedIn = true; } else {
	 * FacesContext.getCurrentInstance().addMessage("form:btn", new
	 * FacesMessage("Bad Credentials")); } return navigateTo; }
	 */
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";

	}

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

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public AdministratorService getAdminService() {
		return AdminService;
	}

	public void setAdminService(AdministratorService adminService) {
		AdminService = adminService;
	}



}
