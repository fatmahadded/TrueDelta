package ManagedBeans.AM;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UpdateModelException;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;

import Entities.Portfolio;
import Entities.TransactionTemporelle;
import interfaces.AssetManagerRemote;
import interfaces.IPortfolioRemoteService;
import interfaces.ITransTempoRemote;
import services.AssetManagerService;
import services.PortfolioService;
import services.TransactionTemporelleService;
import Entities.AssetManager;
import Entities.Client;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@ManagedBean(name = "portfolioBean")
@SessionScoped
public class portfolioBean {
	
	@EJB
	ITransTempoRemote up ;
	
	@EJB
	IPortfolioRemoteService pp ;
	
	@EJB
	AssetManagerRemote amr;
	
	
	public int idClient;
	
	public String type;
	
	public String title;
	
	public int quantity;
	
	public double cours;
	
	public double cm;
	
	public double poids;
	
	public float risque;
	
	public float rendement;
	
	public float rs;
	
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCours() {
		return cours;
	}

	public void setCours(double cours) {
		this.cours = cours;
	}

	public double getCm() {
		return cm;
	}

	public void setCm(double cm) {
		this.cm = cm;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public float getRisque() {
		return risque;
	}

	public void setRisque(float risque) {
		this.risque = risque;
	}

	public float getRendement() {
		return rendement;
	}

	public void setRendement(float rendement) {
		this.rendement = rendement;
	}

	public float getRs() {
		return rs;
	}

	public void setRs(float rs) {
		this.rs = rs;
	}

	public List<TransactionTemporelle> DisplayAll(int idAssetManager , int idClient)
	{
		List<TransactionTemporelle> lp=up.findAllByAssetManagerAndClient(idAssetManager, idClient);
		List<TransactionTemporelle> n =  new ArrayList<TransactionTemporelle>();
		List<TransactionTemporelle> nn =  new ArrayList<TransactionTemporelle>();
		
		double sum = 0;
		double VP = 0;
		float rend = 0;
		
		DecimalFormat df = new DecimalFormat ( ) ;
		df.setMaximumFractionDigits ( 2 ) ; 
		df.setMinimumFractionDigits ( 2 ) ;
		df.setDecimalSeparatorAlwaysShown ( true ) ;
		
		for (int i = 0 ; i<lp.size(); i++) {
			for ( int j =1 ; j!=i & j <lp.size(); j++) {
			if (lp.get(i).getTitle() == lp.get(j).getTitle()) {
				n.add(lp.get(i));
				n.add(lp.get(j));
			}
			}
		}
			for (int lo = 0; lo < lp.size(); lo ++) {
			    if (!(n.contains(lp.get(lo)))) {
			    	if (!(nn.contains(lp.get(lo)))) {
			        nn.add(lp.get(lo));
			        }
			    }
			}
		
		// ************************************ Poids ********************************* //
			
	    sum =n.stream().distinct().mapToDouble(e->e.getQuantity()).sum();
		
		double somme = lp.stream().mapToDouble(e->e.getQuantity()).sum();
		
		for (TransactionTemporelle l : lp) {
			 l.setPoids((l.getQuantity()* 100)/somme) ;
		}
		for (TransactionTemporelle l : n) {
				 l.setPoids((sum* 100)/somme) ;
			}
		
		// ************************************ CM ********************************* //
		
		long nbJours = up.nbJours();
		
		double sumClose = up.getSumClose();
		
		for (TransactionTemporelle l : lp) {
			double aaaa = sumClose/nbJours;
			String bbbb = df.format(aaaa);
			l.setCm(Float.parseFloat(bbbb.replace(',', '.')));
		}
		
		// ************************************ Rendement ********************************* //
		
		List<TransactionTemporelle> dis = lp.stream()
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(TransactionTemporelle::getTitle))),
                        ArrayList::new));
		System.out.println("listaaaaa : "+dis.toString());
		
		List<TransactionTemporelle> desc = up.findOrderByDate();
		
		// ************************ VP     ********************** //
		
		for (int ji = 0 ; ji<desc.size()-1; ji++) {
			    VP += (desc.get(ji).getClose() - desc.get(ji+1).getClose())/desc.get(ji+1).getClose();
		}
		int nbFirm = dis.size();
		double moyenne = (VP/(nbJours - 1))/nbFirm ;
		
		// **********************      ************** //
		
		for (int kk = 0 ; kk<dis.size(); kk++) {
			rend += (dis.get(kk).getPoids()/100)*moyenne;
		}
		
		System.out.println("rendement = "+rend);
		String str = df.format(rend);
		setRendement(Float.parseFloat(str.replace(',', '.')));
		
		// ************************************ Risque ********************************* //
		
		System.out.println("nb de firm : " +dis.size() );
		double fff = 0.0;
		double pkh = 0.0;
		float risk = 0;
		float risk2 =0;
		double kiku=0;
		if (dis.size() == 1) {
			for (int l = 0 ; l<lp.size(); l++) {
				fff += Math.pow((lp.get(l).getClose()-lp.get(l).getCm()),2);
			}
			risk = (float) Math.sqrt(fff/nbJours);
			String strr = df.format(risk);
			setRisque(Float.parseFloat(strr.replace(',', '.')));
		}
		else {
			
			double pkhpkh =dis.stream().mapToDouble(e->e.getPoids()/100).reduce(1, (a, b) -> a * b);
			double su =n.stream().distinct().mapToDouble(e->e.getClose()).sum();
			double sss = su /n.size();
			
			Map<Integer, List<TransactionTemporelle>> groupeeParTitle = lp.stream()
                    .collect(Collectors.groupingBy(TransactionTemporelle::getTitle));
			System.out.println("les groupes sont : " +groupeeParTitle.toString());
			
			for (int ki = 0 ; ki<n.size(); ki++) {
				for (int ku = 0 ; ku<nn.size(); ku++) {
					
					 kiku += (n.get(ki).getClose()-sss)*(nn.get(ku).getClose()-(nn.get(ku).getClose()/2));
				}
			}
			
			int nb = (int) up.nbJours();
			risk2 = (float) (pkhpkh * (1d/nb) * kiku);
			String strri = df.format(risk2);
			setRisque(Float.parseFloat(strri.replace(',', '.')));
				}
		
		// ************************************ RS ********************************* //
		
		Double tt=  up.findByMinDate().stream().findFirst().map(pt -> pt.getClose()).get();
		
		
		double z = rend/tt;
		
		double w = risk2/tt;
		
		float ratio = (float) ((z - 0.5)/ w) ;
		setRs(ratio);
		
		return lp;
		
	}
	
	public String valider(int idClient) {
		Client c = amr.getClientById(idClient);
		String navigateTo = "";
		Portfolio p = new Portfolio();
		//p.setRS(this.rs);
		p.setClient(c);
		pp.AddPortfolio(p);
		System.out.println("rs enregistré");
		navigateTo = "/pages/AssetManager/Clients?faces-redirect=true";

		return navigateTo;
	}
	
	public String addTransaction(int idClient)
	{ 
		String navigateTo = "";
		System.out.println( "Selected Id = "+idClient);
		navigateTo = "/pages/AssetManager/AddTransaction?faces-redirect=true&idClient="+idClient;

		return navigateTo;
	}
	
	/*
	@PostConstruct
	public void init()
	{
		List<TransactionTemporelle> lp=up.findAllByAssetManagerAndClient(1, 1);
	}
	public void Deleteportfolio(int id) {
		return ;
	}
	public void validatePort(int idport) {}
	
*/
	
}
