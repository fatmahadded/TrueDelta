package ManagedBeans.admin;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import Entities.Bank;
import interfaces.AdministratorServiceLocal;
import services.AdministratorService;

@ManagedBean(name = "ajouterbankbean")
@SessionScoped
public class ajouterbankbean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String iban;
	private String swift;
	private String name;
	private String logo;
	
	


	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public AdministratorServiceLocal getAdminservice() {
		return adminservice;
	}

	public void setAdminservice(AdministratorServiceLocal adminservice) {
		this.adminservice = adminservice;
	}
	
	@Inject
	AdministratorServiceLocal adminservice;
	
	public void addBank() {
		String navigateTo = "null";
		navigateTo = "/pages/ajouterbank?faces-redirect=true";
		adminservice.createBank(new Bank(iban,swift,name,logo)); 
	}
	
	
	
}
