package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class MessageriePk  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_sender;
	private int id_receiver;
	@Column(name="Date_ENVOIE")
	private Date Date_envoie;
	
	
	public int getId_sender() {
		return id_sender;
	}
	public void setId_sender(int id_sender) {
		this.id_sender = id_sender;
	}
	public int getId_receiver() {
		return id_receiver;
	}
	public void setId_receiver(int id_receiver) {
		this.id_receiver = id_receiver;
	}
	public Date getDate_envoie() {
		return Date_envoie;
	}
	public void setDate_envoie(Date date_envoie) {
		Date_envoie = date_envoie;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Date_envoie == null) ? 0 : Date_envoie.hashCode());
		result = prime * result + id_receiver;
		result = prime * result + id_sender;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageriePk other = (MessageriePk) obj;
		if (Date_envoie == null) {
			if (other.Date_envoie != null)
				return false;
		} else if (!Date_envoie.equals(other.Date_envoie))
			return false;
		if (id_receiver != other.id_receiver)
			return false;
		if (id_sender != other.id_sender)
			return false;
		return true;
	}

	
}
