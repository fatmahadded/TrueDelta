package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TransactionTemporelle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Date date;

	private TypeTrans type;
	
	private int title;
	
	private int quantity;
	
	private double close;
	
	private double poids;
	
	private double cm;
	
	@ManyToOne
	Portfolio Portfolio;
	
	 @ManyToOne
	 AssetManager AssetManager;
	 
	 @ManyToOne
	 Client Client;
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionT", fetch=FetchType.EAGER)
	 private Set<Asset> asset;
	    
	 public Portfolio getPortfolio() {
		return Portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		Portfolio = portfolio;
	}

	public AssetManager getAssetManager() {
		return AssetManager;
	}

	public void setAssetManager(AssetManager assetManager) {
		AssetManager = assetManager;
	}

	public Client getClient() {
		return Client;
	}

	public void setClient(Client client) {
		Client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TypeTrans getType() {
		return type;
	}

	public void setType(TypeTrans type) {
		this.type = type;
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getCm() {
		return cm;
	}

	public void setCm(double cm) {
		this.cm = cm;
	}

	public Set<Asset> getAsset() {
		return asset;
	}

	public void setAsset(Set<Asset> asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "TransactionTemporelle [id=" + id + ", date=" + date + ", type=" + type + ", title=" + title
				+ ", quantity=" + quantity + ", close=" + close + ", poids=" + poids + ", cm=" + cm + "]";
	}
	
	
	

}
