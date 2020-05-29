package client.ManagedBeans.bankaccount;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.BankAccount;
import services.ClientAccbank;

@ManagedBean (name="baBean")
@SessionScoped
public class BankAccountBean implements Serializable { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int  id;

	private String rib;
	
	private String departement;
	
	private double montant;

	private Integer baIdToBeUpdated;
	
	BankAccount ba;

	//******************************
	public int getId() {
			return id;
		}

		public void setIdBankAccount(int id) {
			this.id= id;
		}

		public String getRib() {
			return rib;
		}

		public void setRib(String rib) {
			this.rib = rib;
		}

       public String getDepartement() {
			return departement;
		}

		public void setDepartement(String departement) {
			this.departement = departement;
		}
		public double getMontant() {
			return montant;
		}

		public void setMontant(double montant) {
			this.montant = montant;
		}
		
		
		public BankAccount getBankAccount() {
			return ba;
		}
		public void setBankAccount(BankAccount ba) {
			this.ba = ba;
		}
		
		
		public Integer getBAIdToBeUpdated() {
			return baIdToBeUpdated;
		}
		public void setBAIdToBeUpdated(Integer baIdToBeUpdated) {
			this.baIdToBeUpdated = baIdToBeUpdated;
		} 
		
		
		
		
		//*****************
		@EJB
		ClientAccbank cab; 
		
		public void addBankAccount() {
			
			ba= (new BankAccount(rib, montant,departement));
			cab.ajouterBankAccount(ba);
			}
		
		public void displayBa(BankAccount ba) 
		{

			this.setMontant(ba.getMontant());
			this.setRib(ba.getRib());
			this.setDepartement(ba.getDepartement());
		    this.setBAIdToBeUpdated(ba.getId());

		}
		public List<BankAccount> findAllBankAccounts()
		{	
			List<BankAccount> bas=cab.findAllBankAccounts();
			return bas;
		}
		
		public void updateAccountBank() 
		{ 
			
			cab.updateAccountBank(new BankAccount(baIdToBeUpdated, montant)); } 
		
		
}
