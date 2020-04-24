package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.AssetManager;

@Remote
public interface AssetManagerRemote {
	public int addAssetManager(AssetManager assetmanager);
	public void removeAssetManagerById(int IdAssetManager);
	public void updateAssetManager (AssetManager assetmanagernewvalues);
	public AssetManager getAssetManagerById(int IdAssetManager);
	public List<AssetManager>GetAllAssetManagerByEtat();
	public void updateEtatAssetManager(int idAssetManager);
	

}
