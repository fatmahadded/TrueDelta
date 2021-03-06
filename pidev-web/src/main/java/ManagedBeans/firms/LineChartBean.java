package ManagedBeans.firms;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.chartistjsf.model.chart.AspectRatio;
import org.chartistjsf.model.chart.LineChartModel;
import org.chartistjsf.model.chart.LineChartSeries;

import Entities.Asset;
import interfaces.IFirmLocalService;

@ManagedBean
@ApplicationScoped
public class LineChartBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	IFirmLocalService firmService;

	private LineChartModel lineChartModel;
	private List<Asset> records;
	public LineChartBean() {
		super();
	}

	public LineChartModel getLineChartModel() {
		records = firmService.getHistoryByCompany(1);
		if(records != null) {
			lineChartModel = new LineChartModel();
			LineChartSeries lineChartSeries1 = new LineChartSeries();
			
			lineChartModel.setAspectRatio(AspectRatio.MAJOR_ELEVENTH);
			int i = 0;
			for (Asset historicalEntry : records) {
				if(i == 0) {
					lineChartModel.addLabel(historicalEntry.getFirm().getSymbol());
					i++;
				}
				lineChartSeries1.setName("Closing Price - ".concat(historicalEntry.getDate().toString().split(" ")[0]));
				lineChartSeries1.set(historicalEntry.getClose());
			}

			lineChartModel.addSeries(lineChartSeries1);
			lineChartModel.setAnimateAdvanced(false);
			lineChartModel.setShowTooltip(true);
			lineChartModel.setShowPoint(true);
			lineChartModel.setChartPadding("10");
			lineChartModel.setHeight("400");
			lineChartModel.setLineSmooth(true);
		}
		
		return lineChartModel;
	}

	public void setLineChartModel(LineChartModel lineChartModel) {
		this.lineChartModel = lineChartModel;
	}
}