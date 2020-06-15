package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.AssetManager;
import Entities.Bank;
import Entities.Bnc;
import Entities.Client;
import Entities.Portfolio;
import interfaces.AdministratorServiceLocal;
import interfaces.AdministratorServiceRemote;

@Stateless
@LocalBean
public class AdministratorService implements AdministratorServiceRemote, AdministratorServiceLocal {

	@PersistenceContext(unitName = "PiDbDS")
	EntityManager em;

	@Override
	public Bank findById(int id) {
		return em.find(Bank.class, id);
	}

	@Override
	public void createBank(Bank bank) {
		em.persist(bank);
	}

	@Override
	public void update(Bank bank) {
		em.merge(bank);
	}

	@Override
	public void deleteBankById(int id) {
		Bank bank = em.find(Bank.class, id);
		System.out.println("ID" + bank);
		em.remove(bank);
	}

	@Override
	public int getNombrClient(String nom, String agence) {

		// TODO Auto-generated method stub
		List<Bank> query = em.createQuery("SELECT d FROM Bank d where d.nom=:nom and d.agence=:agence", Bank.class)
				.setParameter("nom", nom).setParameter("agence", agence).getResultList();
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Bank p : query) {
			result.compute(p.getNom() + "-" + p.getAgence(),
					(nomBank, valeurMap) -> valeurMap == null ? p.getBankAccounts().size()
							: valeurMap + p.getBankAccounts().size());
			
		}

		return result.get(nom + "-" + agence).intValue();

	}

	@Override
	public void deleteBank(Bank bank) {
		if (!em.contains(bank)) {
			bank = em.merge(bank);
		}
		em.remove(bank);
	}

	@Override
	public Bnc recherche(String nom_bank, String iban, Double montant) {
		try {
			TypedQuery<Bnc> query = em.createQuery("SELECT B FROM Bnc B where B.nom_bank=:nom_bank and B.iban=:iban",
					Bnc.class);
			query.setParameter("nom_bank", nom_bank);
			query.setParameter("iban", iban);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void importbase() {
		BufferedReader reader;
		try {

			reader = new BufferedReader(new FileReader("C:\\Users\\ASUS\\Desktop\\basebank.csv"));
			String inputLine;
			int counter = 0;
			while ((inputLine = reader.readLine()) != null) {
				counter++;

				if (counter != 1) {
					String[] data = inputLine.split(Pattern.quote(","), 0);
					
					if ((data[0] != null) && (data[1] != null) && (data[2].length() == 24) && (data[3] != null)) {
						try {
							TypedQuery<Bnc> query = em.createQuery("select I from Bnc I where I.iban=:iban", Bnc.class)
									.setParameter("iban", data[2]);
							if (query.getResultList().size() > 0) {
								
								Bnc b = query.getSingleResult();
								b.setMontant(Double.parseDouble(data[3]));

							} else {
								Bnc bnc = new Bnc();
								
								bnc.setNom_bank(data[0]);
								bnc.setAgence(data[1]);
								bnc.setIban(data[2]);
								bnc.setMontant(Double.parseDouble(data[3]));
								em.persist(bnc);
							}
						} catch (NoResultException e) {
							e.printStackTrace();
						}
					}
				}

			}
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void affecterClientToAsset(int idClient, int idAsset) {
		
		
		Portfolio portfolio = new Portfolio();

		Client client = em.find(Client.class, idClient);
		AssetManager asset = em.find(AssetManager.class, idAsset);
		 
		 portfolio.setClient(client);
		 
		 portfolio.setAssetManager(asset);

		em.persist(portfolio);
	}
	
	@Override 
	public int getIdClient(String iban)
	{
		TypedQuery<Integer> query = em.createQuery("SELECT B.idbankaccount FROM BankAccount B where B.rib=:iban",
				Integer.class);
		query.setParameter("iban", iban);
		query.getSingleResult();
		
		return query.getSingleResult();
		
	}

	@Override
	public int getIdAsset(int IdClient) {
		TypedQuery<Integer> query = em.createQuery("SELECT C.idAsset FROM  Client C where C.idclient=:IdClient",
				Integer.class);
		query.setParameter("IdClient", IdClient);
		query.getSingleResult();
		
		return query.getSingleResult();		
	}
	
	@Override
	public List<Bank> getAllBank() {
		List<Bank> bank = em.createQuery("Select b from Bank b", Bank.class).getResultList();
		return bank;
	}

}
