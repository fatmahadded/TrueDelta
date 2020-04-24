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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AssetManager")
public class AssetManager implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idManager; // Clé primaire
	
	private String username;
	private String lastname;
	private String password;
	private String image;
	private Date dateAjout;
	private Date dateSortie;
	private String cv;
	private int etat;
	


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public int getEtat() {
		return etat;
	}


	public void setEtat(int etat) {
		this.etat = etat;
	}


	public int getIdManager() {
		return idManager;
	}


	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	@OneToMany(cascade = CascadeType.MERGE, mappedBy="AssetManager", fetch= FetchType.EAGER)
	private Set<Portfolio> Portfolios;
	

	
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

	

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}


	@Override
	public String toString() {
		return "AssetManager [idManager=" + idManager + ", username=" + username + ", lastname=" + lastname
				+ ", password=" + password + ", image=" + image + ", dateAjout=" + dateAjout + ", dateSortie="
				+ dateSortie + ", cv=" + cv + ", etat=" + etat + ", Portfolios=" + Portfolios + "]";
	}


	public AssetManager() {}


	public AssetManager(int idManager, String username, String lastname, String password, String image, Date dateAjout,
			Date dateSortie, String cv, int etat, Set<Portfolio> portfolios) {
		super();
		this.idManager = idManager;
		this.username = username;
		this.lastname = lastname;
		this.password = password;
		this.image = image;
		this.dateAjout = dateAjout;
		this.dateSortie = dateSortie;
		this.cv = cv;
		this.etat = etat;
		Portfolios = portfolios;
	}

	
	
}