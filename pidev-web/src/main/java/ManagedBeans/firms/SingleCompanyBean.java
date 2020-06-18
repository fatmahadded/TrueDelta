package ManagedBeans.firms;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import Entities.Asset;
import Entities.Firm;
import interfaces.IFirmLocalService;


@ManagedBean
@ApplicationScoped
public class SingleCompanyBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Firm selectedFirm;
	private List<Asset> history;
	private Map<String, Double> estimation;
	
	@Inject
	IFirmLocalService firmService;

	public Map<String, Double> getEstimation() {
		if(selectedFirm == null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/pidev-web/pages/firms/dashboard.xhtml");
			} catch (IOException e) {
				System.out.println("Error redirecting user to dashboard!");
			}
		}
		this.estimation = firmService.getExpectedReturnByCompany(selectedFirm.getSymbol(), 1);
		return this.estimation;
	}
	
	public Firm getSelectedFirm() {
		if(selectedFirm == null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/pidev-web/pages/firms/dashboard.xhtml");
			} catch (IOException e) {
				System.out.println("Error redirecting user to dashboard!");
			}
		}
		return selectedFirm;
	}
	
	public void setSelectedFirm(Firm selectedFirm) {
		this.selectedFirm = selectedFirm;
	}

	public List<Asset> getHistory() {
		if(selectedFirm == null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/pidev-web/pages/firms/dashboard.xhtml");
			} catch (IOException e) {
				System.out.println("Error redirecting user to dashboard!");
			}
		}
		this.history = firmService.getHistoryByCompany(selectedFirm.getId());
		return history;
	}

	public void setHistory(List<Asset> history) {
		this.history = history;
	}
	
	
}