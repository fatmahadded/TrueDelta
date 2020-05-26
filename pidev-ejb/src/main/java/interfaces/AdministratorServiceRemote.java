package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Bank;
import Entities.Bnc;
@Remote 
public interface AdministratorServiceRemote {
	public void createBank(Bank bank); 
	public void deleteBank(Bank bank);
	public Bank findById(int id);
	public void update(Bank bank);
	public Bnc recherche (String nom_bank , String iban,Double montant);
	List<Bank> getAllBank();
	public void importbase() ;
	public void deleteBankById(int id);
	

}
