package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.regex.Pattern;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Bank;
import Entities.Bnc;
import interfaces.AdministratorServiceLocal;
import interfaces.AdministratorServiceRemote;

@Stateless
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
	public void deleteBank(Bank bank) {
		if (!em.contains(bank)) {
			bank = em.merge(bank);
		}
		em.remove(bank);
	}

	/*
	 * @Override public boolean foundByIban(String ibn) { boolean resulta = false;
	 * Bnc bnc = new Bnc(); if(bnc.getIban().equals(ibn)) { resulta = true; } return
	 * resulta; }
	 */

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
					System.out.println("hhhhh");
					if ((data[0] != null) && (data[1] != null) && (data[2].length() == 24) && (data[3] != null)) {
						try {
							TypedQuery<Bnc> query = em.createQuery("select I from Bnc I where I.iban=:iban", Bnc.class)
									.setParameter("iban", data[2]);
							if (query.getResultList().size() > 0) {
								System.out.println("updatebase");
								Bnc b = query.getSingleResult();
								b.setMontant(Double.parseDouble(data[3]));

							} else {
								Bnc bnc = new Bnc();
								System.out.println("base");
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

}
