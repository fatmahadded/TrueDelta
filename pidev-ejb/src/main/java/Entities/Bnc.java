package Entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bnc")
public class Bnc implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // Clé primaire
	
	private String nom_bank ;
	private String agence;
	private String iban;
	private Double montant;
	
@OneToMany(cascade = CascadeType.ALL, mappedBy="Bank")
	
	private Set<BankAccount> BankAccounts;
	
	public Bnc() {}
	
	public Bnc(String nom_bank,String agence,String iban,Double montant) {
		this.nom_bank=nom_bank;
		this.agence=agence;
		this.iban=iban;
		this.montant=montant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_bank() {
		return nom_bank;
	}
	public void setNom_bank(String nom_bank) {
		this.nom_bank = nom_bank;
	}
	public String getAgence() {
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	@Transient
	public Set<BankAccount> getBankAccounts() {
		return BankAccounts;
	}

	public void setBankAccounts(Set<BankAccount> bankAccounts) {
		BankAccounts = bankAccounts;
	}
	
	
	

}
