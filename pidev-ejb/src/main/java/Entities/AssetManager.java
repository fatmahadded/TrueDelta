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
@Table(name = "AssetManager")
public class AssetManager implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdManager")
	private int id; // Clé primaire
	@Column(name = "Username")
	private String username;
	@Column(name = "Lastname")
	private String lastname;
	@Column(name = "Password")
	private String password;
	@Column(name = "Image")
	private String image;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="AssetManager")
	private Set<Portfolio> Portfolios;
	
	public AssetManager() {}

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
	
	
}