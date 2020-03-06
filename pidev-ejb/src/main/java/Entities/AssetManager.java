package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}