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


@Entity
@Table(name = "Client")
public class Client implements Serializable {
	
	public Client() {}
	public Client(int id, String username, String lastname, String password, String image) {
		super();
		this.id = id;
		this.username = username;
		this.lastname = lastname;
		this.password = password;
		this.image = image;
		
	}
	// Set<Portfolio> portfolios,
	//Set<BankAccount> bankAccounts
//Portfolios = portfolios;
	//BankAccounts = bankAccounts;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdClient")
	private int id; // Clé primaire
	@Column(name = "Username")
	private String username;
	@Column(name = "Lastname")
	private String lastname;
	@Column(name = "Password")
	private String password;
	@Column(name = "Image")
	private String image;

	
	@OneToMany(mappedBy="Client",cascade= {CascadeType.ALL, CascadeType.REMOVE},
	            fetch=FetchType.EAGER)
	private Set<Portfolio> Portfolios;
	
	
	@OneToMany( mappedBy="Clients",cascade= {CascadeType.ALL, CascadeType.REMOVE})

	private Set<BankAccount> BankAccounts;
	
	

	

	public void addPortfolio(Portfolio portfolio){
		portfolio.setClient(this);
		this.Portfolios.add(portfolio);
	}

	public void addBankAccount(BankAccount ba){
		ba.setClients(this);
		this.BankAccounts.add(ba);
	}



	
	
}