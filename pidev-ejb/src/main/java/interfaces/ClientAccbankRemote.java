package interfaces;

import javax.ejb.Remote;
import java.util.List;

import Entities.BankAccount;
import Entities.Portfolio;

@Remote 
public interface ClientAccbankRemote {
	public int addBankAccount(BankAccount ba);
    public void removeBankAccountById(int IdBankAccount);
	public BankAccount findBankAccountById (int Id);

    public String getBankAccountBankDepartmentById(int IdClient);
    
	void affecterBankAccountClient(int IdBankAccount, int IdClient);
	public float getRibyClientIdJPQL(int IdClient);
	
	public List<Integer> getAllBankAccountIDsByClient(int IdClient);
	public List<String> getAllDepartementNamesOfAccountBankByClient(int IdClient);
}
