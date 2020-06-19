package services;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.AssetManager;
import Entities.Client;
import Entities.Portfolio;
import interfaces.AssetManagerRemote;
import Entities.Asset;
import Entities.Transaction;

@Stateless
public class AssetManagerService implements AssetManagerRemote {

	@PersistenceContext
	EntityManager em;

	@Override
	public int addAssetManager(AssetManager assetmanager) {
		em.persist(assetmanager);
		return assetmanager.getIdManager();
	}

	@Override
	public void removeAssetManagerById(int IdAssetManager) {
		System.out.println(" In removeAssetManagerById : ");
		em.remove(em.find(Client.class, IdAssetManager));
		System.out.println("Out of removeAssetManagerById : ");
	}

	@Override
	public void updateAssetManager(AssetManager assetmanagernewvalues) {
		System.out.println("In updateAssetManager");
		AssetManager assetmanager = em.find(AssetManager.class, assetmanagernewvalues.getIdManager());
		assetmanager.setUsername(assetmanagernewvalues.getUsername());
		System.out.println("Out of updateAssetManager :");

	}

	@Override
	public AssetManager getAssetManagerById(int IdAssetManager) {
		System.out.println(" In getAssetManagerById : ");
		AssetManager assetmanager = em.find(AssetManager.class, IdAssetManager);
		System.out.println("Out of getAssetManagerById : ");
		return assetmanager;

	}

	@Override
	public Client getClientById(int IdClient) {
		Client c = em.find(Client.class, IdClient);
		return c;

	}

	@Override
	public List<AssetManager> GetAllAssetManagerByEtat() {
		List<AssetManager> ListAmByEtat = em
				.createQuery("select am from AssetManager am WHERE am.etat=0", AssetManager.class).getResultList();
		return ListAmByEtat;
	}

	@Override
	public void updateEtatAssetManager(int idAssetManager) {

		AssetManager assetmanager = em.find(AssetManager.class, idAssetManager);
		assetmanager.setEtat(1);
	}

	@Override
	public Portfolio GetPortfolio(int idPortfolio) {

		Portfolio portfolio = em.find(Portfolio.class, idPortfolio);
		return portfolio;

	}

	// Calcul P-value
	public float CalculDuPvalueAuCoursDelajournée(int idAsset, int idTrans) {
		Asset asset = em.find(Asset.class, idAsset);
		Transaction trans = em.find(Transaction.class, idTrans);

		float A = (float) ((asset.getClose() - asset.getOpen()) * (trans.getQuantite()));
		// asset.setValue(A);
		return A;
	}
	// Calcul Montant

	public float CalculDuMontantDesActions(int idAsset, int idTrans) {

		Asset asset = em.find(Asset.class, idAsset);
		Transaction trans = em.find(Transaction.class, idTrans);

		float Montant = (float) (asset.getHigh() * trans.getQuantite());
		return Montant;
	}

	@Override
	public List<Client> allClientsByAssetManager(int id) {
		AssetManager am = em.find(AssetManager.class, id);
		List<Client> clients = new ArrayList<>();
		for (Client c : am.getClients()) {
			clients.add(c);
		}

		return clients;
	}

	@Override
	public List<Client> getClientsByAssetManager(int id) {
		TypedQuery<Client> query = em.createQuery("SELECT c from Client c where c.AssetManager.idManager=:id",
				Client.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
