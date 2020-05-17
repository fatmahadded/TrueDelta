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
	private int contract_id;
	@Column(name = "Date_creation")
	private Date date_creation;
	@Column(name = "Date_end")
	private Date date_end;
	 //avec ou sans rique
	@Column(name = "Titre")
	private String titre;
    //@Column(name = "Shares_nbr", nullable = false)
	//private int sharesnbr;
	//@Column(name = "Bonds_nbr", nullable = false)
	//private int bondsnbr;
	@Column(name = "Commission_AM")
	private float commission;
	@Column(name = "Prime_Client")
	private float prime;
	@Column(name="Risque_Estimated")
	private float riskk;
	 
	@ElementCollection
	private List<String> motcle;
	@Column(name = "Etat")
	private boolean etat;
	@Column(name = "Reponse")
	private String reponse;
    
	@Column(name="Type_Contract")
    @Enumerated(EnumType.STRING)
    private type_contract type_contract;
    public enum type_contract {Shares, Bonds}

    private Integer contractIdToBeUpdated;
    //********

	
//les relations
@OneToMany(cascade = CascadeType.ALL, mappedBy = "Contract")
private Set<Guarantee> Guarantees;
@ManyToOne
 Client client;
@ManyToOne
 AssetManager am;
@ManyToOne
Ensemble ensemble;
	

//geters w setters	
public Contract() {
	super();}
	
public type_contract getType_contract() {
		return type_contract;
	}

	public void setType_contract(type_contract type_contract) {
		this.type_contract = type_contract;
	}
	 public Set<Guarantee> getGuarantees() {
	    	return Guarantees;
	    }
	    public void SetGuarantee (Set<Guarantee> guarantees) {
	    	Guarantees = guarantees;
	    }
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
	public Ensemble getEnsemble() {
		return ensemble;
	}
	public void setEnsemble(Ensemble ensemble) {
		this.ensemble = ensemble;
	}
//***************************
	
	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
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
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public float getRisk() {
		return riskk;
	}
	public void setRisk(float riskk) {
		this.riskk = riskk;}
	
	
	public List<String> getMotcle() {
		return motcle;
	}
	public void setMotcle(List<String> motcle) {
		this.motcle = motcle;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	

	
	public Contract(Integer contractIdToBeUpdated,Date date_end,float commission, float prime,float riskk) {
		 super();

		this.setContractIdToBeUpdated(contractIdToBeUpdated);
			this.date_end=date_end;
			this.commission=commission;
			this.prime=prime;
			this.riskk=riskk;
		}
	public Contract(int contract_id,String titre,Date date_creation,Date date_end,float commission, float prime,float riskk, List<String> motcle, boolean etat, String reponse) {
    super();
    this.date_creation=date_creation;
	this.date_end=date_end;
	this.commission=commission;
	this.prime=prime;
	this.contract_id = contract_id;
	this.titre = titre;
	this.motcle = motcle;
	this.etat = etat;
	this.reponse = reponse;
	this.riskk=riskk;
	}

	
	
	public Contract(Date date_creation,Date date_end,String titre,type_contract type_contract,float commission, float prime,float riskk, List<String> motcle, boolean etat, String reponse) {
	    super();
	    this.date_creation=date_creation;
		this.date_end=date_end;
		this.commission=commission;
		this.prime=prime;
		this.titre = titre;
		this.type_contract=type_contract;
		this.motcle = motcle;
		this.etat = etat;
		this.reponse = reponse;
		this.riskk=riskk;
		}
	
	public Contract(Date date_creation,Date date_end,String titre,type_contract type_contract,float commission, float prime,float riskk) {
	    super();
	    this.date_creation=date_creation;
		this.date_end=date_end;
		this.commission=commission;
		this.prime=prime;
		this.titre = titre;
		this.type_contract=type_contract;
		
		this.riskk=riskk;
		}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addGuarantee(Guarantee guarantee){
		this.Guarantees.add(guarantee);
}
	public Integer getContractIdToBeUpdated() {
		return contractIdToBeUpdated;
	}
	public void setContractIdToBeUpdated(Integer contractIdToBeUpdated) {
		this.contractIdToBeUpdated = contractIdToBeUpdated;
	}
	
}
