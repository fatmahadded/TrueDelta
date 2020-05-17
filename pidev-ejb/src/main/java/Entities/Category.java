package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="category_ID")
	private int category_id;
	@Column(name="Premuim_Max",nullable = false) 
	private float premuim_Max;
	@Column(name="Premuim_Min",nullable = false) 
	private float premuim_Min;
	@Column(name="Description",nullable = false) 
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Category")
	private Set<Contract> Contracts;
	
	public Category(){}

	public int getCategory_id() {
		return category_id;
	}

	public float getPremuim_Max() {
		return premuim_Max;
	}

	public void setPremuim_Max(float premuim_Max) {
		this.premuim_Max = premuim_Max;
	}

	public float getPremuim_Min() {
		return premuim_Min;
	}

	public void setPremuim_Min(float premuim_Min) {
		this.premuim_Min = premuim_Min;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} }
	