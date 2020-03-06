package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client implements Serializable {
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

}