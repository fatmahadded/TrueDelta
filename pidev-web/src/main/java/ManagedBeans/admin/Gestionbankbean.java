package ManagedBeans.admin;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.MenuModel;

import Entities.Bank;
import services.AdministratorService;

@ManagedBean()
@SessionScoped
public class Gestionbankbean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nom;
	private String agence;
	private int nbr;
	private List<Bank> banks;

	private MenuModel model;

	private List<Bank> filteredBank;

	private Bank selectedBank;

	@EJB
	AdministratorService adminservice;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public AdministratorService getAdminservice() {
		return adminservice;
	}

	public void setAdminservice(AdministratorService adminservice) {
		this.adminservice = adminservice;
	}

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public List<Bank> getBanks() {
		banks = adminservice.getAllBank();
		return banks;
	}

	public List<Bank> getFilteredBank() {
		return filteredBank;
	}

	public void setFilteredBank(List<Bank> filteredBank) {
		this.filteredBank = filteredBank;
	}

	public Bank getSelectedBank() {
		return selectedBank;
	}

	public void setSelectedBank(Bank selectedBank) {
		this.selectedBank = selectedBank;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public void addBank() {
		adminservice.createBank(new Bank(nom, agence, nbr));
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "the bank has been added to the database", "."));

	}

	public MenuModel getModel() {
		return model;
	}

	public void removeBank(int id) {
		adminservice.deleteBankById(id);
	}

	public int CountClient(String nom, String agence) {
		System.out.println("count");
		return adminservice.getNombrClient(nom, agence);

	}

	public String retour() {
		System.out.println("retour");
		return "/index.xhtml";
	}
}
