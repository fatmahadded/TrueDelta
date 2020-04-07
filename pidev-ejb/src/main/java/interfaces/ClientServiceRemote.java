package interfaces;

import javax.ejb.Remote;
import java.util.List;

import Entities.Client;
import Entities.Portfolio;
import Entities.BankAccount;
import Entities.Transaction;

@Remote 
public interface ClientServiceRemote {

//***********client<->portfolio*********************
	
public int addClient(Client client);
public void removeClientById(int IdClient);
public void updateClient (Client clientnewvalues);
public Client getClientById(int IdClient);
public List<Client> findAllClients();


public int addPortfolio(Portfolio portfolio);
public void removePortfolioById(int IDCount);
public void updatePortfolio(Portfolio portfolionewvalues);
public Portfolio findPortfolioById (int Id);

void affecterPortfolioAClient(int IDCount, int IdClient);
//public void desaffecterPorfolioDuClient(int IDCount, int IdClient);
public long getNombrePortfolioJPQL();
public float geGainByClientIdJPQL(int IdClient);
public Double getGainMoyenByTransactionId(int IdTransaction);
public List<Integer> getAllPortfoliosIDsByClient(int IdClient);

//**************client<->accountbank************************

public int addBankAccount(BankAccount ba);
public void removeBankAccountById(int IdBankAccount);

void affecterBankAccountClient(int IdBankAccount, int IdClient);
public List<Integer> getAllBankAccountIDsByClient(int IdClient);
 }

