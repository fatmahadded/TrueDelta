package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.*;

@Remote
public interface AssetManagerRemote {
	public int addAssetManager(AssetManager assetmanager);
	public void removeAssetManagerById(int IdAssetManager);
	public void updateAssetManager (AssetManager assetmanagernewvalues);
	public AssetManager getAssetManagerById(int IdAssetManager);
	public List<AssetManager>GetAllAssetManagerByEtat();
	public void updateEtatAssetManager(int idAssetManager);
	public Portfolio GetPortfolio(int idPortfolio );
	//Calcul P-value
		public float CalculDuPvalueAuCoursDelajournée(int idAsset , int  idTrans );
	//Calcul Montant
		public float CalculDuMontantDesActions(int idAsset , int  idTrans );
}
