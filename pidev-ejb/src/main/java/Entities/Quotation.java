package Entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Entities.Contract.type_contract;


@Entity
@Table(name = "Prices")
@Inheritance(strategy = InheritanceType.JOINED)
public class Quotation implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Quotation_ID")
	private int quotation_id;
	
	@Enumerated(EnumType.STRING)
	private type_contract type_contract;

	public Quotation() {}
	public int getQuotation_id() {
		return quotation_id;}
		public void setQuotation_id(int quotation_id) {
			this.quotation_id = quotation_id;
	}



}
