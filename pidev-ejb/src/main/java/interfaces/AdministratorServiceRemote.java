package interfaces;

import javax.ejb.Remote;

import Entities.Bank;
import Entities.BankAccount;
@Remote 
public interface AdministratorServiceRemote {
	public int ajouterBank(Bank bank); 
	public void supprimerBank(int idBank);
	public BankAccount findCountbyCount(int IdBank , String NumCount, double montant);
	

}
