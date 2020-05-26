package ManagedBeans.admin;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Bank;
import services.AdministratorService;

@ManagedBean()
@SessionScoped
public class GestionBankBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nom;
	private String agence;
	private int  nbr;
	
	
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
	
	private List<Bank> banks;
	
	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public List<Bank> getBanks() {
		banks = adminservice.getAllBank();
		return banks;
	}
	
	public void addBank() {
		adminservice.createBank(new Bank(nom,agence,nbr)); 
	}
	
	public void removeBank(int id) {
		adminservice.deleteBankById(id);
	}
	
	public void importBaseBank()
	{
		System.out.println("kkkk");
		adminservice.importbase();
	}
}
