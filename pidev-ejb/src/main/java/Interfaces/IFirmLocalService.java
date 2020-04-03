package Interfaces;

import java.util.List;

import javax.ejb.Local;

import Entities.Firm;
import Entities.HistoricalEntry;

@Local
public interface IFirmLocalService {
	public void fetchFirms();
	public void listMarket();
	public void fetchHistory();
	public void addHistoryEntry(HistoricalEntry entry);
}
