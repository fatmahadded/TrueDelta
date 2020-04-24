package Entities;

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
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="IdBank")
	private int id; // Clé primaire
	@Column(name="IBAN")
	private String iban;
	@Column(name="Swift")
	private String swift;
	@Column(name="Name")
	private String name;
	@Column(name="Logo")
	private String logo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Bank")
	private Set<BankAccount> BankAccounts;

	public Bank() {}
	public Bank(String iban, String swift, String name, String logo) {
		this.iban=iban;
		this.swift=swift;
		this.name=name;
		this.logo=logo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Set<BankAccount> getBankAccounts() {
		return BankAccounts;
	}

	public void setBankAccounts(Set<BankAccount> bankAccounts) {
		BankAccounts = bankAccounts;
	}
	
	
}
