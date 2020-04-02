package interfaces;

import Entities.Bank;
import Entities.BankAccount;

public interface AdministratorServiceLocal {
	public void ajouterBank(Bank bank); 
	public void supprimerBank(int idBank);
	public BankAccount findCountbyCount(int IdBank , String NumCount, double montant);
	public void affecterBank(int Id);  
}
