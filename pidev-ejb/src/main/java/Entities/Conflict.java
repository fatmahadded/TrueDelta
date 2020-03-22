package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@ManyToOne
	Administrator administrators;
	
	@OneToOne(mappedBy="conflict")
	private Portfolio Portfolio;
	
	public Conflict() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public Administrator getAdministrators() {
		return administrators;
	}

	public void setAdministrators(Administrator administrators) {
		this.administrators = administrators;
	}
	
}
