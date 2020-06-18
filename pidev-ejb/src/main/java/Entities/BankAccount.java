package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BankAccount")
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdBankAccount")
	private int idbankaccount; // Clé primaire
	@Column(name = "RIB")
	private String rib;
	@Column(name = "Montant")
	private double montant;
	@Column(name = "agence")
	private String agence;
	@Column(name = "nomBank")
	private String nom;

	@ManyToOne
	Client Clients;
	
	@ManyToOne
	Bank Bank;
	
	public BankAccount() {}
	
	public BankAccount(int idbankaccount, String rib, double montant, String agence,String nom) {
		super();
		this.idbankaccount= idbankaccount;
		this.rib = rib;
		this.montant = montant;
		this.agence = agence;
		this.nom = nom;
		
	}

	public int getIdBankAccount() {
		return idbankaccount;
	}

	public void setIdBankAccount(int idbankaccount) {
		this.idbankaccount = idbankaccount;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public int getIdbankaccount() {
		return idbankaccount;
	}

	public void setIdbankaccount(int idbankaccount) {
		this.idbankaccount = idbankaccount;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Client getClients() {
		return Clients;
	}

	public void setClients(Client clients) {
		Clients = clients;
	}

	public Bank getBank() {
		return Bank;
	}

	public void setBank(Bank bank) {
		Bank = bank;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
}
