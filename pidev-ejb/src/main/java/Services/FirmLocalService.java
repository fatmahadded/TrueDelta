package Services;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.io.IOUtils;

import Entities.Firm;
import Entities.HistoricalEntry;
import Interfaces.IFirmLocalService;

@Stateless
public class FirmLocalService implements IFirmLocalService {
	
	/*private class CronTask extends TimerTask {
		
		
		public CronTask() {
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}
		
		

	}*/
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void fetchFirms() {
		URL url;
		try {
			url = new URL("ftp://ftp.nasdaqtrader.com/symboldirectory/");
			String content = IOUtils.toString(url.openStream(), "utf-8");

			if (content.contains("nasdaqlisted.txt")) {
				url = new URL("ftp://ftp.nasdaqtrader.com/symboldirectory/nasdaqlisted.txt");
				InputStreamReader reader = new InputStreamReader(url.openStream());
				BufferedReader input = new BufferedReader(reader);
				String inputLine;
				int counter = 0;
				while ((inputLine = input.readLine()) != null) {
					counter++;
					if (counter != 1 && !inputLine.contains("File Creation Time")) {
						/**
						 * 0 : Symbol 1 : Security Name 2 : Market Category 3 : Test Issue 4 : Financial
						 * Status 5 : Round Lot Size 6 : ETF 7 : NextShares
						 */
						String[] data = inputLine.split(Pattern.quote("|"), 0);
						Firm firm = new Firm(data[0], data[1]);
						em.merge(firm);
					}
				}
				input.close();
			}

			if (content.contains("otherlisted.txt")) {
				url = new URL("ftp://ftp.nasdaqtrader.com/symboldirectory/otherlisted.txt");
				InputStreamReader reader = new InputStreamReader(url.openStream());
				BufferedReader input = new BufferedReader(reader);
				String inputLine;
				int counter = 0;
				while ((inputLine = input.readLine()) != null) {
					counter++;
					if (counter != 1 && !inputLine.contains("File Creation Time")) {
						/**
						 * 0 : ACT Symbol 1 : Security Name 2 : Exchange 3 : CQS Symbol 4 : ETF 5 :
						 * Round Lot Size 6 : Test Issue 7 : NASDAQ Symbol
						 */
						String[] data = inputLine.split(Pattern.quote("|"), 0);
						Firm firm = new Firm(data[7], data[1]);
						em.merge(firm);
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

	@Override
	public void listMarket() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fetchHistory() {
		TypedQuery<Firm> query = em.createQuery("select f from Firm f", Firm.class);
		List<Firm> firms = (List<Firm>) query.setMaxResults(10).getResultList(); // For test purposes, just 10 firms is enough
		this.getHistoricalDataBySymbol(firms);
		/*Timer timer = new Timer();
		CronTask task = new CronTask();
		timer.scheduleAtFixedRate(task, 0, 10000 * 60 * 60 * 24); // Every 24 hours : 10000 is 10 sec*/
	}

	@Override
	public void addHistoryEntry(HistoricalEntry entry) {
	}
	
	/**
	 * This is a method to get the historical data for over 8000 firms from Yahoo! Finance
	 */
	public void getHistoricalDataBySymbol(List<Firm> firms) {
		for (Firm firm : firms) {
			System.out.println(firm.getSymbol());
			try {
				ProcessBuilder pb = new ProcessBuilder(
						"C:\\Users\\RedJ\\AppData\\Local\\Programs\\Python\\Python37\\python.exe",
						"C:\\Users\\RedJ\\Documents\\workspace\\pidev\\pidev-ejb\\src\\main\\java\\Services\\getStock.py",
						firm.getSymbol());
				Process p = pb.start();

				BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String s = null;
				int counter = 0;
				while ((s = in.readLine()) != null) {
					counter++;
					if (counter != 1 && counter != 2 && !s.contains("rows")) {
						String[] data = s.replaceAll("\\s{2,}", ",").split(",");
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						Date date = format.parse(data[0]);
						HistoricalEntry newEntry = new HistoricalEntry(date, Double.parseDouble(data[1]),
								Double.parseDouble(data[2]), Double.parseDouble(data[3]), Double.parseDouble(data[4]),
								Long.parseLong(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]));
						newEntry.setFirm(firm);
						em.persist(newEntry);
					}
				}
				in.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
}
