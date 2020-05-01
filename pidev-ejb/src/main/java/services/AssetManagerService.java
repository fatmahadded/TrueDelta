package services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.AssetManager;
import Entities.Client;
import Entities.Portfolio;
import interfaces.AssetManagerRemote;
import Entities.Asset;
import Entities.Transaction;

@Stateless
@LocalBean
public class AssetManagerService implements AssetManagerRemote {
	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;
	@Override
	public int addAssetManager(AssetManager assetmanager) {
		System.out.println(" In addAssetManager: ");
		em.persist(assetmanager);
		System.out.println ("Out of addAssetManager "+assetmanager.getIdManager());
		/*
		try {
			EmailService email = new EmailService();
			email.sendEmail("ahmed.jaiem@esprit.tn", "test", "ahmed.jaiem@esprit.tn", "Get shwity");
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return assetmanager.getIdManager();
	}

	@Override
	public void removeAssetManagerById(int IdAssetManager) {
		System.out.println (" In removeAssetManagerById : ");
		em.remove(em.find(Client.class, IdAssetManager));
		System.out.println ("Out of removeAssetManagerById : ");		
	}

	@Override
	public void updateAssetManager(AssetManager assetmanagernewvalues) {
		System.out.println("In updateAssetManager" );
		AssetManager assetmanager = em.find(AssetManager.class, assetmanagernewvalues.getIdManager());
		assetmanager.setUsername(assetmanagernewvalues.getUsername());
		System.out.println("Out of updateAssetManager :");
		
	}

	@Override
	public AssetManager getAssetManagerById(int IdAssetManager) {
		 System.out.println (" In getAssetManagerById : ");
		 AssetManager assetmanager = em.find(AssetManager.class, IdAssetManager);
		 System.out.println ("Out of getAssetManagerById : ");
		 return assetmanager;
		
	}

	@Override
	public List<AssetManager> GetAllAssetManagerByEtat() {
        List<AssetManager> ListAmByEtat = em.createQuery("select am from AssetManager am WHERE am.etat=0", AssetManager.class).getResultList();
        return ListAmByEtat;
	}

	@Override
	public void updateEtatAssetManager(int idAssetManager ) {
		
		AssetManager assetmanager = em.find(AssetManager.class, idAssetManager);
		assetmanager.setEtat(1);
	}
	
	@Override
    public Portfolio GetPortfolio(int idPortfolio ) {
		
		Portfolio portfolio = em.find(Portfolio.class, idPortfolio);
		return portfolio;
		
	}
	


	
	
	
	
	
	//Calcul P-value
	public float CalculDuPvalueAuCoursDelajournée(int idAsset , int  idTrans ) {
		Asset asset = em.find(Asset.class, idAsset);
		Transaction trans = em.find(Transaction.class, idTrans);

		float A = (float) ((asset.getClose() - asset.getOpen()) * (trans.getQuantite()));
		//asset.setValue(A);
		return A;
	
	
	
	
	
	

}

	
}
