package Services;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.commons.io.IOUtils;

import Entities.Firm;
import Interfaces.IFirmLocalService;

@Stateless
public class FirmLocalService implements IFirmLocalService {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void fetchFirms() {
		URL url;
		try {
			url = new URL("ftp://ftp.nasdaqtrader.com/symboldirectory/");
			String content = IOUtils.toString(url.openStream(), "utf-8");
			
			if(content.contains("nasdaqlisted.txt")) {
				url = new URL("ftp://ftp.nasdaqtrader.com/symboldirectory/nasdaqlisted.txt");
				InputStreamReader reader = new InputStreamReader(url.openStream());
				BufferedReader input = new BufferedReader(reader);
				String inputLine;
				int counter = 0;
				while((inputLine = input.readLine()) != null) {
					counter++;
					if(counter!=1 && !inputLine.contains("File Creation Time")) {
						/**
						 * 0 : Symbol
						 * 1 : Security Name
						 * 2 : Market Category
						 * 3 : Test Issue
						 * 4 : Financial Status
						 * 5 : Round Lot Size
						 * 6 : ETF
						 * 7 : NextShares
						 */
						String[] data = inputLine.split(Pattern.quote("|"),0);
						Firm firm = new Firm(data[0], data[1]);
						em.persist(firm);
					}
				}
				input.close();
			}
			
			if(content.contains("otherlisted.txt")) {
				url = new URL("ftp://ftp.nasdaqtrader.com/symboldirectory/otherlisted.txt");
				InputStreamReader reader = new InputStreamReader(url.openStream());
				BufferedReader input = new BufferedReader(reader);
				String inputLine;
				int counter = 0;
				while((inputLine = input.readLine()) != null) {
					counter++;
					if(counter!=1 && !inputLine.contains("File Creation Time")) {
						/**
						 * 0 : ACT Symbol
						 * 1 : Security Name
						 * 2 : Exchange
						 * 3 : CQS Symbol
						 * 4 : ETF
						 * 5 : Round Lot Size
						 * 6 : Test Issue
						 * 7 : NASDAQ Symbol
						 */
						String[] data = inputLine.split(Pattern.quote("|"),0);
						Firm firm = new Firm(data[7], data[1]);
						em.persist(firm);
					}
				}
				input.close();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
