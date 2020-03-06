package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Conflict")
public class Conflict implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdConflict")
	private int id; // Clé primaire
	@Column(name = "Initiator")
	private String initiator;
	@Column(name = "Decision")
	private String decision;
}
