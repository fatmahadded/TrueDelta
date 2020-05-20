package interfaces;




import java.util.List;

import javax.ejb.Local;


import Entities.Contract;
import Entities.Client;



@Local



public interface IContracthomeServiceLocal {
	public void ajouterContract(Contract contract);
	public void affecterContratAClient(int idcontract, int id);

	public void removeContract(int idcontract);
	public int updateContract(Contract newContract);

	public Contract findContractById(int idcontract);
	public List<Contract> findAllContracths();
	public List<Contract> findAllContractsbyclient(int id);

	public long getNombreContractJPQL() ;

	public float getPrimeByClientIdJPQL(int id) ;
		
	public float getCommisionByClientIdJPQL(int id) ;

	//public long calculerNbrTitres(int idClient); 
}
