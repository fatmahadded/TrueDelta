package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Membre;
import Entities.Contract;

@Remote

public interface contRemote {
	public Membre getUserBylogin(String login,String password);

	public int ajouterMembre(Membre membre);
	public void ajouterContractMembre(Contract contract,String loginClient,String loginAssetManager);
	public void modifierEtat(int idClient,String titreContract);
	public int affecterEtoile(int idMembre);
	public List<Contract> chercherContractMotCle(String motC);
	public int ajouterEnsemeble(String nomBase,List<String> motsCle);
	public void affecterContractsEnsmeble(int idConnaissance);
}
