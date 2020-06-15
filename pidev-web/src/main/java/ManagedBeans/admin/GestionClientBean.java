package ManagedBeans.admin;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Bnc;
import services.AdministratorService;

@ManagedBean()
@SessionScoped
public class GestionClientBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String iban;
	private String nomBank;
	private Double montant;
	private int idClient;
	private int idAsset;


	@EJB
	AdministratorService adminservice;

	public AdministratorService getAdminservice() {
		return adminservice;
	}

	public void setAdminservice(AdministratorService adminservice) {
		this.adminservice = adminservice;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getNomBank() {
		return nomBank;
	}

	public void setNomBank(String nomBank) {
		this.nomBank = nomBank;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdAsset() {
		return idAsset;
	}

	public void setIdAsset(int idAsset) {
		this.idAsset = idAsset;
	}

	public void importBaseBank() {
		adminservice.importbase();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful Update", "."));

	}

	public void verifierCompte(String iban) {

		Bnc bnc = adminservice.recherche(nomBank, iban, montant);
		System.out.println("montant " + bnc.getMontant());

		if (montant <= bnc.getMontant()) {

			int idClient = adminservice.getIdClient(iban);
			int idAsset = adminservice.getIdAsset(idClient);
			adminservice.affecterClientToAsset(idClient, idAsset);
			System.out.println("montant verifier ");
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Successful",
					"the client has been assigned to the asset manager Id : " + idAsset));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "the amount is not found in the base", "."));
			System.out.println("montant non verifier  ");
		}

	}

}