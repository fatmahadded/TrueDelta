package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Contract;
import Entities.Client;




@Remote
public interface IContracthomeServiceRemote{
public int addContracth(Contract cn);
public void removeContracth(int id);
public int updateContracth(Contract cn);
public Contract findContractById(int id);
public List<Contract> findAllContracths();
public List<Contract> findAllContractsbyclient(int id);

public long getNombreContractJPQL() ;

public float getPrimeByClientIdJPQL(int id) ;
	
public float getCommisionByClientIdJPQL(int id) ;

public long calculerNbrTitres(int idClient); 
}

	





