package ManagedBeans.AM;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import Entities.AssetManager;
import Entities.Client;
import Entities.Firm;
import Entities.TransactionTemporelle;
import Entities.TypeTrans;
import interfaces.AssetManagerRemote;
import interfaces.IFirmLocalService;
import interfaces.ITransTempoRemote;

@ManagedBean(name = "transactionBean")
@SessionScoped
public class transactionBean  {
	
	private TransactionTemporelle transT;
	
	@EJB
	ITransTempoRemote service;
	
	@EJB
	IFirmLocalService sv;
	
	@EJB
	AssetManagerRemote amr;
	
	public AssetManager am;
	public Client c;
	private TypeTrans type;
    private TypeTrans[] types;
    private int firm;
    private List<Firm> firms;
    private int quantity;
    private Date date;
    private double close ;
    
    private List<Firm> listAll;
    
	public List<Firm> getListAll() {
		listAll = sv.listFirms();
		return listAll;
	}
	public void setListAll(List<Firm> listAll) {
		this.listAll = listAll;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public TypeTrans getType() {
		return type;
	}
	public void setType(TypeTrans type) {
		this.type = type;
	}
	public TypeTrans[] getTypes() {
		return types;
	}
	public void setTypes(TypeTrans[] types) {
		this.types = types;
	}
	public int getFirm() {
		return firm;
	}
	public void setFirm(int firm) {
		this.firm = firm;
	}
	public List<Firm> getFirms() {
		return firms;
	}
	public void setFirms(List<Firm> firms) {
		this.firms = firms;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public TransactionTemporelle getTransT() {
		return transT;
	}
	public void setTransT(TransactionTemporelle transT) {
		this.transT = transT;
	}
	
	public AssetManager getAm() {
		return am;
	}
	public void setAm(AssetManager am) {
		this.am = am;
	}
	public Client getC() {
		return c;
	}
	public void setC(Client c) {
		this.c = c;
	}
	public String add(int idAssetManager , int idClient) throws ParseException  {
		am = amr.getAssetManagerById(idAssetManager);
		c = amr.getClientById(idClient);
        transT = new TransactionTemporelle();
        transT.setType(type);
        transT.setTitle(firm);
        transT.setQuantity(quantity);
        transT.setDate(date);
        close = service.getClose(firm, date);
        transT.setClose(close);
        transT.setAssetManager(am);
        transT.setClient(c);
        String goTo = "null";
        service.add(transT);
        goTo = "/pages/AssetManager/portfolioByClient?faces-redirect=true&idClient="+idClient;
        return goTo;

    }
    
	public TypeTrans[] Types() {
        for (TypeTrans r : TypeTrans.values()) {
            System.out.println("****TypeTrans:***" + r.name());
        }
        types = TypeTrans.values();
        return TypeTrans.values();
    }
	
	public List<Firm> Firms() {
		firms = sv.listFirms();
		for (Firm f : firms) {
			System.out.println("****Frims :***" + f.getName());
		}
		return firms;
    }
	

}

