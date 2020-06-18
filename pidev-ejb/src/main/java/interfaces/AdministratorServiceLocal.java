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
	List<Bank> getAllBank();
	public void importbase() ;
	public void deleteBankById(int id);
	//public User getUserByEmailAndPassword(String email, String password);
	public void affecterClientToAsset(int idClient,int idAsset);
	public int getNombrClient( String nom, String agence);
	public int getIdClient(String iban);
	public int getIdAsset(int IdClient);

	
}
