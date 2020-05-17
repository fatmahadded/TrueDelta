package client.ManagedBeans.contractBean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Contract;
import Entities.Contract.type_contract;
import services.ContractHomeService;

@ManagedBean(name = "addcontract")
@SessionScoped
public class addcontract implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int contract_id;
    private Date date_creation;
    private Date date_end;
    private float commission;
	private float prime;
	private String titre;
	private float riskk;
    private type_contract type_contract;
    private Integer contractIdToBeUpdated;
//**
    
    public type_contract getType_contract() {
		return type_contract;
	}

	public void setType_contract(type_contract type_contract) {
		this.type_contract = type_contract;
	}
	
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
	
	public Integer getContractIdToBeUpdated() {
		return contractIdToBeUpdated;
	}

	public void setContractIdToBeUpdated(Integer contractIdToBeUpdated) {
		this.contractIdToBeUpdated = contractIdToBeUpdated;
	}
	
	//***
	

	@EJB
	ContractHomeService cnService; 
	Contract cn;
	//***


	
	public ContractHomeService getContractHomeService() {
		return cnService;
	}

	public void setContractHomeService(ContractHomeService  cnService) {
		this.cnService = cnService;
	}
	
	public Contract getContract () {
		return cn;
	}
	public void setContract(Contract  cn) {
		this.cn = cn;
	}
	//**
	
		public void addContract() {
			String navigateTo = "null";
			navigateTo = "/pages/clients/addcontract?faces-redirect=true";
		cn= (new Contract(date_creation, date_end,titre,type_contract,commission, prime,riskk));
			cnService. addContracth(cn);
	}
		public List<Contract> findAllContracths()
		{	String navigateTo = "null";
		navigateTo = "/pages/clients/addcontract?faces-redirect=true";
			List <Contract>  Contracth=cnService. findAllContracths();
			return Contracth;}
		
		public void removeContracth(int id) {
			String navigateTo = "null";
			navigateTo = "/pages/clients/addcontract?faces-redirect=true";
			cnService.removeContracth(id);
		}
		
		public void displayContract(Contract cn) 
		{
			String navigateTo = "null";
			navigateTo = "/pages/clients/addcontract?faces-redirect=true";
			this.setContract_id(cn.getContract_id());
			this.setDate_creation(cn.getDate_creation());
			this.setDate_end(cn.getDate_end() );
		    this.setCommission(cn.getCommission() );
		    this.setPrime(cn.getPrime());
		    this.setContractIdToBeUpdated(cn.getContract_id());
		}
		public int updateContracth()
		
		{String navigateTo = "null";
		navigateTo = "/pages/clients/addcontract?faces-redirect=true";
			cnService.updateContracth(new Contract( contractIdToBeUpdated, date_end,commission,prime,riskk)); } 

		
	
	

}
