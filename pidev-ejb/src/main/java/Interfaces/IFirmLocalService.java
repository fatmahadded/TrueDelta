package interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import Entities.Firm;
import Entities.HistoricalEntry;

@Local
public interface IFirmLocalService {
	public void fetchFirms();
	public void listMarket();
	public void fetchHistory();
	public void addHistoryEntry(HistoricalEntry entry);
	public List<HistoricalEntry> getHistory(int limit);
	public List<HistoricalEntry> getHistoryByCompany(int company_id);
	public Map<String, Double> getExpectedReturnByCompany(String symbol);
	public Map<Object, Object> getEstimationByCompany();
	public int getFirmCount();
	public int getRecordsCount();
}
