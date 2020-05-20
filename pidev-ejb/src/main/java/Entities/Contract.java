package Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;


import javax.persistence.ElementCollection;

import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "Contract")
@Inheritance(strategy = InheritanceType.JOINED)
public class Contract implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Conract_ID")
	private int idcontract;
	@Column(name = "Date_creation")
	private Date date_creation;
	@Column(name = "Date_end")
	private Date date_end;
	@Column(name = "Nom_de_l'entreprise_vendeuse")
	private String nomentr;
	@Column(name = "Titre_nbr", nullable = false)
	private int titrenbr;
    @Column(name = "Commission_AM")
	private float commission;
	@Column(name = "Prime_Client")
	private float prime;
	@Column(name="Risque_Estimaté_du_titre")
	private float riskk;
	@Column(name="Montant_Remboursé")
	private float mnt;
	@Column(name="Description",nullable = false) 
	private String description;
	@Column(name="Type_Contract")
    @Enumerated(EnumType.STRING)
   type_contract type_contract;
// @ElementCollection
	//private List<String> motcle;
	@Column
	private boolean etat;
	
    
    
    private Integer contractIdToBeUpdated;
    //********

	
//les relations
//@OneToMany(cascade = CascadeType.ALL, mappedBy = "Contract")
//private Set<Guarantee> Guarantees;
@ManyToOne
 Client client;
@ManyToOne
 AssetManager am;


//constructeur
public Contract() {}
public Contract(Date date_creation,Date date_end,String nomentr,int titrenbr,float commission,float prime, float riskk,float mnt,String description,Boolean etat,type_contract type_contract) {
	    this.date_creation=date_creation;
	    this.date_end=date_end;
	      this.nomentr=nomentr;
	    this.titrenbr=titrenbr;
	      this.commission=commission;
		this.prime=prime;
		this.riskk=riskk;
		this.type_contract=type_contract;
		this.mnt=mnt;
		this.description=description;
		this.etat=etat;
	}
public Contract(int idcontract, Date date_end, float mnt, float prime, float commission,int titrenbr, type_contract type_contract) {
   this.idcontract=idcontract;
    this.date_end=date_end;
    this.titrenbr=titrenbr;
      this.commission=commission;
	this.prime=prime;
	this.type_contract=type_contract;
	this.mnt=mnt;
}

//getters and setters
	
        
		// public Set<Guarantee> getGuarantees() {
	    	//return Guarantees;
	    //}
	    //public void SetGuarantee (Set<Guarantee> guarantees) {
	    	//Guarantees = guarantees;
	    //}
	    public AssetManager getAssetManager() {
	    	return am;
	    }
	    public void setAssetManager(AssetManager am) {
	    	this.am = am;
	    }
	    public Client getClient() {
	    	return client;
	    }
	    public void setClient(Client client) {
	    	this.client = client;
	    }
	
//***************************
	
	public int getContract_id() {
		return idcontract;
	}
	public void setContract_id(int id) {
		this.idcontract = idcontract;
	}


	public Date getDate_creation() {
		return date_creation;
	}


	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	public String getNom_Ent() {
		return nomentr;
	}

	public void setNom_Ent(String nomentr) {
		this.nomentr = nomentr;
	}
	public int getTitre_nbr() {
		return titrenbr;
	}

	public void setTitre_nbr(int titrenbr) {
		this.titrenbr = titrenbr;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}
	
	public float getRisk() {
		return riskk;
	}
	public void setRisk(float riskk) {
		this.riskk = riskk;}
	
	public float getMNT() {
		return mnt;
	}
	public void setMNT(float mnt ){
		this.mnt = mnt;}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public boolean getEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
	
	
	public void settype_contract(type_contract type_contract) {
		this.type_contract = type_contract;
	}
	
	
	public Entities.type_contract gettype_contract() {return type_contract;}
	
	public void settype_contract(String type_contract) {}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	public Integer getContractIdToBeUpdated() {
		return contractIdToBeUpdated;
	}
	public void setContractIdToBeUpdated(Integer contractIdToBeUpdated) {
		this.contractIdToBeUpdated = contractIdToBeUpdated;
	}
	
}
