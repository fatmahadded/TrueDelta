package ManagedBeans.firms;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import Entities.Asset;
import Entities.Firm;
import interfaces.IFirmLocalService;
import services.FirmLocalService;

@ManagedBean
@ApplicationScoped
public class DashboardBean implements Serializable {

	@Inject
	IFirmLocalService firmService;
	
	private int records;
	private int nbFirms;
	private List<Asset> assets;
	private static final long serialVersionUID = 1L;
	private Firm selectedCompany;
	
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
		System.out.println(this.nbFirms);
	}

	public List<Asset> getAssets() {
		this.assets = firmService.getHistory(200);
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	public Firm getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(Firm selectedCompany) {
		this.selectedCompany = selectedCompany;
	}
	
	public void onRowSelect(SelectEvent event) {
		try {
			FacesContext faces = FacesContext.getCurrentInstance();
			SingleCompanyBean bean = (SingleCompanyBean) faces.getApplication().getVariableResolver().resolveVariable(faces, "singleCompanyBean");
			bean.setSelectedFirm(((Asset)event.getObject()).getFirm());
			faces.getExternalContext().redirect("/pidev-web/pages/firms/single.xhtml");
		} catch (IOException e) {
			System.out.println("Error getting event object!!");
		}
    }
}
