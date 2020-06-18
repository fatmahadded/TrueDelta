package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdTransaction")
	private int id; // Clé primaire
	@Column(name = "Amount")
	private double amount;
	@Column(name = "Quantity")
	private int quantite;
	@ManyToOne
	Portfolio Portfolio;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
	private Set<Asset> asset;

	public Set<Asset> getAsset() {
		return asset;
	}

	public void setAsset(Set<Asset> asset) {
		this.asset = asset;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Transaction() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Portfolio getPortfolio() {
		return Portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		Portfolio = portfolio;
	}

}
