package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Contract;
import Entities.Client;




@Remote
public interface IContracthomeServiceRemote{
	
public int ajouterContract(Contract contract);
public void affecterContratAClient(int idcontract, int idclient);

public void removeContract(int idcontract);
public void updateContract(Contract newContract);

public Contract findContractById(int idcontract);
public List<Contract> findAllContracths();

public List<Contract> findAllContractsbyclient(int idclient);

public long getNombreContractJPQL() ;

public float getPrimeByClientIdJPQL(int idclient) ;
	

//public long calculerNbrTitres(int idClient); 
}





	





