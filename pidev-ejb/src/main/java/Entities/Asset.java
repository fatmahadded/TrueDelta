package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HistoricalEntity")
public class Asset implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id; // Clé primaire

	@Column(name = "Date")
	private Date date;

	@Column(name = "Open")
	private double open;

	@Column(name = "High")
	private double high;

	@Column(name = "Low")
	private double low;

	@Column(name = "Close")
	private double close;

	@Column(name = "Volume")
	private long volume;

	@Column(name = "Dividends")
	private double dividends;

	@Column(name = "StockSplits")
	private double stock_splits;

	@Enumerated(EnumType.STRING)
	private Type type;

	@ManyToOne
	private Transaction transaction;

	@ManyToOne
	private Firm firm;
	
	@ManyToOne
	private TransactionTemporelle transactionT;

	public Asset() {
		super();
	}

	public Asset(Date date, double open, double high, double low, double close, long volume, double dividends,
			double stock_splits) {
		super();
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.dividends = dividends;
		this.stock_splits = stock_splits;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public double getDividends() {
		return dividends;
	}

	public void setDividends(double dividends) {
		this.dividends = dividends;
	}

	public double getStock_splits() {
		return stock_splits;
	}

	public void setStock_splits(double stock_splits) {
		this.stock_splits = stock_splits;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public TransactionTemporelle getTransactionT() {
		return transactionT;
	}

	public void setTransactionT(TransactionTemporelle transactionT) {
		this.transactionT = transactionT;
	}

}
