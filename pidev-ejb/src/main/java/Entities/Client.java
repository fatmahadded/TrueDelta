package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Entities.User;
import Entities.Contract;


@Entity
@Table(name = "Client")
public class Client implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IdClient")
private int id; // Clé primaire
@Column(name = "First_Name_Client")
private String firstname;
@Column(name = "Last_Name_Client")
private String lastname;
@Column(name = "Adress_Mail_Client")
private String email;
private String password;
private Boolean isActif;
//@Column(name = "Image")
//private String image;

	
//relation

@OneToMany(mappedBy="Client",cascade= {CascadeType.ALL, CascadeType.REMOVE},
            fetch=FetchType.EAGER)
private Set<Portfolio> Portfolios;	        

@OneToMany( mappedBy="Clients",cascade= {CascadeType.ALL, CascadeType.REMOVE})
 private Set<BankAccount> BankAccounts;

@OneToMany(cascade = CascadeType.ALL, mappedBy="Client")
private Set<Contract> Contracts;
	
	

//constructeur
public Client() {}
public Client(String lastname, String firstname, String email, String password,  Boolean isActif) {
	this.lastname=lastname;
	this.firstname=firstname;
	this.email=email;
	this.password=password;
	this.setIsActif(isActif);}

public Client(int id,String lastname, String firstname, String email, String password,  Boolean isActif) {
	this.id=id;
	this.lastname=lastname;
	this.firstname=firstname;
	this.email=email;
	this.password=password;
	this.setIsActif(isActif);}


public int getId() {
	return id;
}

public void setId( int id) {
		this.id = id;
	}
public String getEmail() {return email;}
public void setEmail(String adresseMail){this.email = adresseMail;} 
public String getFirstname() {return firstname;}
public void setFirstname(String firstname) {this.firstname = firstname;}
public String getLastname() {return lastname;}
public void setLastname(String lastname) {this.lastname = lastname;}
public String getPassword() {return password;	}
public void setPassword(String password) {this.password = password;}

public Boolean getIsActif() {
	return isActif;
}
public void setIsActif(Boolean isActif) {
	this.isActif = isActif;
}


	
	public Set<Contract> getContracts() {
		return Contracts;
	}
	public void setContracts(Set<Contract> contracts) {
		Contracts = contracts;
	}
	
	
	public Set<Portfolio> getPortfolios() {
		return Portfolios;
	}

	public void setPortfolios(Set<Portfolio> portfolios) {
		Portfolios = portfolios;
	}

	public Set<BankAccount> getBankAccounts() {
		return BankAccounts;
	}

	public void setBankAccounts(Set<BankAccount> bankAccounts) {
		BankAccounts = bankAccounts;
	}


    
	


	

	//@Override
	//public String toString() {
		//return "Client [IdClient=" +id+ ", AdressMail=" + email + ", Lastname=" + lastname+ ", Firstname" + firstname +
				 //", Password=" + password + ", Image=" + image +", Portfolios=" + Portfolios + ", BankAccounts=" +BankAccounts +  "]";
	//}

public void addBankAccount(BankAccount ba){
		ba.setClients(this);
		this.BankAccounts.add(ba);
	}
public void addContract(Contract cn){
	this.Contracts.add(cn);
}


	
	
}