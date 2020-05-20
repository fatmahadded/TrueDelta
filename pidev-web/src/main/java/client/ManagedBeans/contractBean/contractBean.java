package client.ManagedBeans.contractBean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Contract;
import Entities.type_contract;
import services.ContractHomeService ;

@ManagedBean (name="contractBean")
@SessionScoped

public class contractBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Date date_creation;
	private Date date_end;
	private String nomentr;
	private int titrenbr;
	private float commission;
	private float prime;
	private float riskk;
	private float mnt;
	private String description;

	private Boolean etat; 
	private type_contract type_contract;
	private Integer contractIdToBeUpdated;
	Contract contract;


	
	


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
	
	public type_contract gettype_contract() {
		return type_contract;
	}

	public void settype_contract(type_contract type_contract) {
		this.type_contract = type_contract;
	}


	public Integer getContractIdToBeUpdated() {
		return contractIdToBeUpdated;
	}


	public void setContractIdToBeUpdated(Integer contractIdToBeUpdated) {
		this.contractIdToBeUpdated = contractIdToBeUpdated;
	}  
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;}
	
	@EJB
	ContractHomeService contractService; 
	
	public void addContract() {
		String navigateTo = "null";
		navigateTo = "/pages/clients/ajoutcontract?faces-redirect=true";
		contract= (new Contract(date_creation, date_end,nomentr,titrenbr,commission,prime, riskk,mnt,description,etat, type_contract));
		contractService.ajouterContract(contract);
		}
		
		public List<Contract> getContracts()
		{	List <Contract> contracts=contractService.findAllContracths();
			return contracts;
		}
		public void removeEmploye(int idcontract) {
			contractService.removeContract(idcontract);
		}
		public void displayContract(Contract cnt) 
		{
		this.setDate_creation(cnt.getDate_creation());
		this.setDate_end(cnt.getDate_end());
		this.setNom_Ent(cnt.getNom_Ent()); 
		this.setTitre_nbr(cnt.getTitre_nbr());
		this.setCommission(cnt.getCommission());
		this.setPrime(cnt.getPrime());
		this.setRisk(cnt.getRisk());
		this.setMNT(cnt.getMNT());
		this.setDescription(cnt.getDescription());
		
		this.setEtat(cnt.getEtat());
		
		this.settype_contract(cnt.gettype_contract());
		this.setContractIdToBeUpdated(cnt.getContract_id());
		}
		public void  updateContract() 
		{ contractService.updateContract(new Contract(contractIdToBeUpdated, date_end, mnt, prime, commission, titrenbr, type_contract)); } 
		
		
		

	
}
