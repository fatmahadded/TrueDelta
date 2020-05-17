package interfaces;

import javax.ejb.Remote;
import java.util.List;

import Entities.BankAccount;
import Entities.Client;
import Entities.Portfolio;

@Remote 
public interface ClientAccbankRemote {
	public void addBankAccount(BankAccount ba);
	 public void removeBankAccountById(int idba);
	 public BankAccount findBankAccountById (int idba);
	 public BankAccount getaccountbankByDepatement(String departement);
	 public List<BankAccount> findAllBankAccounts(); 
	 public void updateAccountBank(BankAccount userNewValues);
	
	public List<String> getAllDepartementNamesOfAccountBankByClient(int id) ;

	public float getRibyClientIdJPQL(int idclient) ;
			
	 //public void affecterBankAccountClient(int idba, int idclient);
}
//nnaml methode wahda mta3 ajout