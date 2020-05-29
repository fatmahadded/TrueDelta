package interfaces;

import javax.ejb.Remote;
import java.util.List;

import Entities.BankAccount;
import Entities.Client;
import Entities.Portfolio;

@Remote 
public interface ClientAccbankRemote {
	public void ajouterBankAccount(BankAccount ba);
	public BankAccount findBankAccountById (int id);
	public BankAccount getaccountbankByDepatement(String departement);
	public List<BankAccount> findAllBankAccounts(); 
	public void updateAccountBank(BankAccount baNewValues);
	
	public List<String> getAllDepartementNamesOfAccountBankByClient(int id) ;

	public float getRibyClientIdJPQL(int id) ;
			
	 //public void affecterBankAccountClient(int idba, int idclient);
}
//nnaml methode wahda mta3 ajout