package interfaces;

import javax.ejb.Local;

import Entities.Bank;
import Entities.Bnc;

@Local
public interface AdministratorServiceLocal {
	public void createBank(Bank bank); 
	public void deleteBank(Bank bank);
	public Bank findById(int id);
	public void update(Bank bank);
	public Bnc recherche (String nom_bank , String iban,Double montant);
	//public  boolean foundByIban(String ibn);
	public void importbase() ;
	  
}
