package ManagedBeans.firms;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import interfaces.IFirmLocalService;

@ManagedBean
public class DashboardBean implements Serializable {

	@Inject
	IFirmLocalService firmService;
	
	private int records;
	private int nbFirms;
	private static final long serialVersionUID = 1L;
	
	public DashboardBean() {
	}

	public int getRecords() {
		this.records = firmService.getRecordsCount();
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public int getNbFirms() {
		this.nbFirms = firmService.getFirmCount();
		return nbFirms;
	}

	public void setNbFirms(int nbFirms) {
		this.nbFirms = nbFirms;
	}

	public void fetchRecords() {
		if (nbFirms > 0) {
			firmService.fetchHistory();
			this.records = firmService.getRecordsCount();
		}
	}

	public void fetchFirms() {
		firmService.fetchFirms();
		this.nbFirms = firmService.getFirmCount();
	}
}
