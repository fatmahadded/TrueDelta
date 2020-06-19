package interfaces;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import Entities.TransactionTemporelle;

@Local
public interface ITransTempoRemote {
	
	void add(TransactionTemporelle entry);
	List<TransactionTemporelle> findAll();
	List<TransactionTemporelle> findAllByAssetManagerAndClient(int idManager, int idClient);
	public double getClose(int idFirm,Date date) throws ParseException;
	List<TransactionTemporelle> findGroupByFirm(int id);
	List<TransactionTemporelle> findOrderByDate();
	List<TransactionTemporelle> findDistinct();
	List<TransactionTemporelle> findByMinDate();
	long nbJours();
	double getSumClose();
}