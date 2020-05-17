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
		public void setClient(BankAccount ba) {
			this.ba = ba;
		}
		public ClientAccbank getClientAccbank() {
			return cab;
		}

		public void setClientAccbank(ClientAccbank  cab) {
			this.cab =cab;
		}
		
		public Integer getBAIdToBeUpdated() {
			return baIdToBeUpdated;
		}
		public void setBAIdToBeUpdated(Integer baIdToBeUpdated) {
			this.baIdToBeUpdated = baIdToBeUpdated;
		} 
		//*****************
		BankAccount ba;
		@EJB
		ClientAccbank cab; 
		
		public void addBankAccount() {
			String navigateTo = "null";
			navigateTo = "/pages/clients/addclient?faces-redirect=true";
			ba= (new BankAccount(rib, montant,departement));
			cab.addBankAccount(ba);
			}
		public void removeBankAccountById(int id) {
			String navigateTo = "null";
			navigateTo = "/pages/clients/addclient?faces-redirect=true";
			cab.removeBankAccountById(id);
		}
		
		public void displayBa(BankAccount ba) 
		{
			String navigateTo = "null";
			navigateTo = "/pages/clients/addclient?faces-redirect=true";
			this.setMontant(ba.getMontant());
			this.setRib(ba.getRib());
			this.setDepartement(ba.getDepartement());
		    this.setBAIdToBeUpdated(ba.getId());

		}
		public List<BankAccount> findAllBankAccounts()
		{	String navigateTo = "null";
		navigateTo = "/pages/clients/addclient?faces-redirect=true";
			List<BankAccount> bas=cab.findAllBankAccounts();
			return bas;
		}
		
		public void updateAccountBank() 
		{ 
			String navigateTo = "null";
			navigateTo = "/pages/clients/addclient?faces-redirect=true";
			cab.updateAccountBank(new BankAccount(baIdToBeUpdated, montant)); } 
		
		
}
