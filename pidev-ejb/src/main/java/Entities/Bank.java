package Entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name= "Bank")
public class Bank implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="IdBank")
	private int id; // Clé primaire
	@Column(name="nom")
	private String nom;
	@Column(name="agence")
	private String agence;
	@Column(name="nombreClient")
	private int  nbr;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Bank")
	
	private Set<BankAccount> BankAccounts;

	public Bank() {}
	public Bank(String nom, String agance, int nbr) {
		this.nom=nom;
		this.agence=agance;
		this.nbr=nbr;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	@Transient
	public Set<BankAccount> getBankAccounts() {
		return BankAccounts;
	}

	public void setBankAccounts(Set<BankAccount> bankAccounts) {
		BankAccounts = bankAccounts;
	}
	
	
}
