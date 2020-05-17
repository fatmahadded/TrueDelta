package Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table( name= "Accepted_Contract")

public class Ensemble implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKBase;
	@Column
	private String nomBase;
	@Column
	private Date dateAjout;
	@ElementCollection
	private List<String> motcle;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="ensemble")
	private Set<Contract> contracts;
	public int getIdKBase() {
		return idKBase;
	}
	public void setIdKBase(int idKBase) {
		this.idKBase = idKBase;
	}
	public String getNomBase() {
		return nomBase;
	}
	public void setNomBase(String nomBase) {
		this.nomBase = nomBase;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}
	public List<String> getMotcle() {
		return motcle;
	}
	public void setMotcle(List<String> motcle) {
		this.motcle = motcle;
	}
	public Set<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}
	public Ensemble(int idKBase, String nomBase, Date dateAjout, List<String> motcle) {
		super();
		this.idKBase = idKBase;
		this.nomBase = nomBase;
		this.dateAjout = dateAjout;
		this.motcle = motcle;
	}
	public Ensemble(String nomBase, Date dateAjout, List<String> motcle) {
		super();
		this.nomBase = nomBase;
		this.dateAjout = dateAjout;
		this.motcle = motcle;
	}
	public Ensemble() {
		super();
	}

}
