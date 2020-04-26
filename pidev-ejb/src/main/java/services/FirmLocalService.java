package services;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import interfaces.IFirmLocalService;
import utils.FloatUtils;

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

	@Override
	public List<HistoricalEntry> getHistory(int limit) {
		List<HistoricalEntry> list = em.createQuery("select h from HistoricalEntry h", HistoricalEntry.class).setMaxResults(limit).getResultList();
		return list;
	}
	
	// Resources to estimate the expected return and the risk
	// https://corporatefinanceinstitute.com/resources/knowledge/trading-investing/expected-return/
	// https://www.investopedia.com/articles/basics/10/guide-to-calculating-roi.asp
	// https://www.investopedia.com/terms/r/rateofreturn.asp
	@Override
	public Map<String, Double> getExpectedReturnByCompany(String symbol) {
		try {
			// Calculating expected return by company
			Firm firm = em.createQuery("select f from Firm f where f.symbol=:symbol", Firm.class).setParameter("symbol", symbol).getSingleResult();
			int year;
			Map<Integer, Double> RoIs = new HashMap<Integer, Double>();
			for(year = 2010; year<2020; year++) {
				List<HistoricalEntry> historicalEntries = em.createQuery("select h from HistoricalEntry h where h.firm=:firm and year(h.date)=:year order by h.date", HistoricalEntry.class).setParameter("firm", firm).setParameter("year", year).getResultList();
				// I'm going to calculate the RoI for one stock (1) from the total volume
				double initialValue = historicalEntries.get(0).getOpen();
				double finalValue = historicalEntries.get(historicalEntries.size()-1).getClose();
				Double returnOnInvestement = ((finalValue-initialValue)*1/initialValue*1)*100;
				RoIs.put(year, FloatUtils.round(returnOnInvestement, 2));
			}
			
			Map<Double, Integer> probabilities = new HashMap<Double, Integer>();
			RoIs.forEach((key,value)->{
				probabilities.compute(value, (k,v)-> v == null ? 1 : v++);
			});
			double deviation = FloatUtils.standardDeviation(RoIs.values());
			double expectedReturn = 0.0;
			for(Entry<Double, Integer> entry: probabilities.entrySet()) {
				Double size = new Double(probabilities.size());
				Double value = new Double(entry.getValue());
				double newCount = (entry.getKey()*(value/size));
				expectedReturn = expectedReturn + newCount;
			}
			Map<String, Double> result = new HashMap<String, Double>();
			result.put("Return", FloatUtils.round(expectedReturn,2));
			result.put("Risk", FloatUtils.round(deviation, 2));
			return result;
		}catch(IndexOutOfBoundsException exception) {
			System.out.println("No History found!");
		}
		return null;
	}

	@Override
	public Map<Object, Object> getEstimationByCompany() {
		Map<Object, Object> result = new HashMap<Object, Object>();
		List<Firm> firms = em.createQuery("select f from Firm f", Firm.class).setMaxResults(10).getResultList();
		for(Firm firm : firms) {
			Map<String, Double> estimation = getExpectedReturnByCompany(firm.getSymbol());
			result.put(firm.getName()+"-"+firm.getSymbol(), estimation);
		}
		return result;
	}
	
	
}
