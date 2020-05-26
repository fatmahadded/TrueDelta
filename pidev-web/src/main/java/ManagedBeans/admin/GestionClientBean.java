package ManagedBeans.admin;

import java.io.Serializable;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.MenuModel;

import services.AdministratorService;

@ManagedBean()
@SessionScoped
public class GestionClientBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	AdministratorService adminservice;

	private MenuModel model;

	public AdministratorService getAdminservice() {
		return adminservice;
	}

	public void setAdminservice(AdministratorService adminservice) {
		this.adminservice = adminservice;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public void importBaseBank() {
		adminservice.importbase();
		FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour", "réussie"));
        
	}

	
	public MenuModel getModel() {
		return model;
	}
	
}