package Entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Entities.Type;
import Entities.Choix;


import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
@Entity
@Table(name = "Contract")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Contract implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Conract_ID")
	private int idcontract;
	@Column(name = "Date_creation")
	@Temporal(TemporalType.DATE)
	private Date date_creation;
	@Column(name = "Date_end")
	@Temporal(TemporalType.DATE)
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
	@Column(name="Gain")
	private float gain;
	@Column(name="Description",nullable = false) 
	private String description;
	
    @Enumerated(EnumType.STRING)
   Type type;
    @Enumerated(EnumType.STRING)
     Choix  choix ;

    
    private Integer contractIdToBeUpdated;
    //********

	
//*****les relations*****
//@OneToMany(cascade = CascadeType.ALL, mappedBy = "Contract")
//private Set<Guarantee> Guarantees;

    //@ManyToOne
// Client Clients;



//constructeur
public Contract() {super(); }

public Contract(Date date_creation,Date date_end,String nomentr,int titrenbr,float commission,float prime,float riskk, float gain ,String description,Type type,Choix choix)
{
	
	this.date_creation=date_creation;
      this.date_end=date_end;
	  this.titrenbr=titrenbr;
	  this.commission=commission;
	  this.prime=prime;
	  this.type=type;
	  this.gain=gain;
	  this.nomentr=nomentr;
	  this.riskk=riskk;
	  this.description=description;
	  this.type=type;
	  this.choix=choix;
      //this.setIsAccepted(isAccepted);
}
public Contract(String nomentr,int titrenbr,float commission,float prime,float riskk, float gain ,String description,Type type,Choix choix)
{
	
	
	  this.titrenbr=titrenbr;
	  this.commission=commission;
	  this.prime=prime;
	  this.type=type;
	  this.gain=gain;
	  this.nomentr=nomentr;
	  this.riskk=riskk;
	  this.description=description;
	  this.type=type;
	  this.choix=choix;
      //this.setIsAccepted(isAccepted);
}
public Contract(int idcontract,Date date_end, float gain, float prime, float commission,int titrenbr, Type type) {
   this.idcontract=idcontract;
    this.date_end=date_end;
    this.titrenbr=titrenbr;
      this.commission=commission;
	this.prime=prime;
	this.type=type;
	this.gain=gain;
}

//getters and setters relation
	
//public Client getClients() {
	//return Clients;
//}

//public void setClients(Client clients) {
	//Clients = clients;
//}

	
//************getter setter cle***************
	
	public int getContract_id() {
		return idcontract;
	}
	public void setContract_id(int idcontract) {
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
	
	public float getGain() {
		return gain;
	}
	public void setGain(float gain ){
		this.gain = gain;}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(Type type) {
		this.type = type;
	}
	public Entities.Type getType() {return type;}
	public void setType(String type) {}
	
	
	
	public void setChoix(Choix choix) {
	this.choix = choix;
	}
	public Entities.Choix getChoix() {return choix;}
	public void setChoix(String choix) {}
	
	
	//*****methode to string****
		//@Override
		//public String toString() {
		//	return "Contract [idcontract=" + idcontract + ",date creation=" + date_creation  + ",date fin=" + date_end + ",nom entreprise=" + nomentr+ ",nombre de titre=" + titrenbr+ ",commission de l'AM" +commission+ ",Prime du client=" + prime+ ",Risque=" + riskk  +", gain=" + gain + ",Description=" + description +",type=" + type +", choix=" + choix +",client=" + Clients +  "]";}
			
	

	public Integer getContractIdToBeUpdated() {
		return contractIdToBeUpdated;
	}
	public void setContractIdToBeUpdated(Integer contractIdToBeUpdated) {
		this.contractIdToBeUpdated = contractIdToBeUpdated;
	}

	

	

	
	
}