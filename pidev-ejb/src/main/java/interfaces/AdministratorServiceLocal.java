package interfaces;

import java.util.List;

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
	public void importbase() ;
	List<Bank> getAllBank();
	public void deleteBankById(int id);
	  
}
