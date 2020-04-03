package interfaces;

import javax.ejb.Local;

import Entities.Bank;
import Entities.BankAccount;

@Local
public interface AdministratorServiceLocal {
	public int ajouterBank(Bank bank); 
	public void supprimerBank(int idBank);
	public BankAccount findCountbyCount(int IdBank , String NumCount, double montant);
	  
}
