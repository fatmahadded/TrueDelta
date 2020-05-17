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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public BankAccount( String rib, double montant, String departement) {
		this.rib = rib;
		this.montant = montant;
		this.departement = departement;
		
	}
	
	public BankAccount(int id, String rib, double montant, String departement) {
       this.id= id;
		this.rib = rib;
		this.montant = montant;
		this.departement = departement;
		
	}
	public BankAccount( int id,double montant) {
		this.id= id;
		this.montant = montant;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdBankAccount")
	private int id; // Clé primaire
	@Column(name = "RIB")
	private String rib;
	@Column(name = "Montant")
	private double montant;
	@Column(name = "Departement")
	private String departement;

	@ManyToOne
	Client Clients;
	
	@ManyToOne
	Bank Bank;
	
	@ManyToOne
	Bank Bnc;
	
	
	
	
	

	public int getId() {
		return id;
	}

	public void setIdBankAccount(int id) {
		this.id= id;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	
		
	
	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
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

	public Bank getBnc() {
		return Bnc;
	}

	public void setBnc(Bank bnc) {
		Bnc = bnc;
	}
	
}
