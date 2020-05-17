package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Contract;
import Entities.Guarantee;


@Remote
public interface IgarantieServiceRemote {

	
	public int addGuarantee(Guarantee gua);
	public void removeGuarantee(int id);
	public void updateGuarantee(Guarantee cn);
	public Guarantee findGuaranteeById(int id);
	
	public List<Guarantee> findAllGurantees();	
	public List<Guarantee> findAllGuranteesbyclient(int id);
	public List<Guarantee> findAllGuranteesbyContract(int id);
	public List<Guarantee> findAllGuranteesbyContractSharing();
	public List<Guarantee> findAllGuranteesbyContractBonding();
}
