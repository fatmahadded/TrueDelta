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
@Table(name = "Guarantee")
public class Guarantee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	
	@Column(name="Guarantee_ID")
	private int guarantee_id;
	@Column(name="Code_Guarantee",nullable = false) 
	private int code_guarantee;
	@Column(name="Amount_Franchise",nullable = false) 
	private float amount_franchise;
	@Column(name="Amount_Limit",nullable = false) 
	private float amount_limit;
	@Column(name="Description",nullable = false) 
	private String description;
	@Column(name="Type",nullable = true) 
	private String type;
	
	@ManyToOne
	Contract Contract;
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public float getRefund() {
		return refund;
	}

	public void setRefund(float refund) {
		this.refund = refund;
	}

	@Column(name="Refund",nullable = false) 
	private float refund;
	

	
	
	public Guarantee(){}

	public int getGuarantee_id() {
		return guarantee_id;
	}

	public int getCode_guarantee() {
		return code_guarantee;
	}

	public void setCode_guarantee(int code_guarantee) {
		this.code_guarantee = code_guarantee;
	}

	public float getAmount_franchise() {
		return amount_franchise;
	}

	public void setAmount_franchise(float amount_franchise) {
		this.amount_franchise = amount_franchise;
	}

	public float getAmount_limit() {
		return amount_limit;
	}

	public void setAmount_limit(float amount_limit) {
		this.amount_limit = amount_limit;
	}

	public void setGuarantee_id(int guarantee_id) {
		this.guarantee_id = guarantee_id;
	}

	public Contract getContract() {
		return Contract;
	}

	public void setContract(Contract contract) {
		Contract = contract;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
