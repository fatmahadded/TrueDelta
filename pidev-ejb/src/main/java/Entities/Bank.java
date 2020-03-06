package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
