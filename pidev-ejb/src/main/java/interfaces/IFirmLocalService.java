package interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import Entities.Firm;
import Entities.Asset;

@Local
public interface IFirmLocalService {
	public void fetchFirms();
	public void listMarket();
	public void fetchHistory();
	public List<Asset> getHistoryByCompany(int company_id);
	public void addHistoryEntry(Asset entry);
	public List<Asset> getHistory(int limit);
	public Map<String, Double> getExpectedReturnByCompany(String symbol);
	public Map<Object, Object> getEstimationByCompany();
	public int getFirmCount();
	public int getRecordsCount();
}
