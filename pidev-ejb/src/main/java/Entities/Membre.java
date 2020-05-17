package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Membre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMembre;
	@Column
	private String login;
	@Column
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column
	private int nbStars;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="Client")
	private Set<Contract> ClientContracts;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="AssetManager")
	private Set<Contract> AssetManagerContracts;
	public int getIdMembre() {
		return idMembre;
	}
	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getNbStars() {
		return nbStars;
	}
	public void setNbStars(int nbStars) {
		this.nbStars = nbStars;
	}
	
	
	public Set<Contract> getClientContracts() {
		return ClientContracts;
	}
	public void setClientContracts(Set<Contract> clientContracts) {
		ClientContracts = clientContracts;
	}
	public Set<Contract> getAssetManagerContracts() {
		return AssetManagerContracts;
	}
	public void setAssetManagerContracts(Set<Contract> assetmanagerContracts) {
		AssetManagerContracts = assetmanagerContracts;
	}
	public Membre(int idMembre, String login, String password, Role role, int nbStars) {
		super();
		this.idMembre = idMembre;
		this.login = login;
		this.password = password;
		this.role = role;
		this.nbStars = nbStars;
	}
	public Membre(String login, String password, Role role, int nbStars) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
		this.nbStars = nbStars;
	}
	public Membre() {
		super();
	}
	
}
