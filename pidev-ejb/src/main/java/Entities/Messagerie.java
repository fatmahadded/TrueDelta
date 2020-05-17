package Entities;


import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;




@Entity
public class Messagerie implements Serializable{ /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private MessageriePk MessageriePk;

	@ManyToOne
	@JoinColumn(name = "id_receiver", referencedColumnName = "User_ID", insertable = false, updatable = false)
	User receiver;
	@OneToOne
	@JoinColumn(name = "id_sender", referencedColumnName = "User_ID", insertable = false, updatable = false)
	User sender;

	private String Contenu;
	@Column(name="Subject")
	private String Subject;
	@Column(name = "Date_VU")
	private Date Date_vu;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private type_message type_message;
    
	public enum type_message {inbox("inbox"),
		starred("starred"),
		sent("sent"),
		drafts("drafts"),
		important("important"),
		messagerie("messagerie");
	    private type_message (String name){
    } 
	}
	
	public Messagerie() {
	}

	
	public MessageriePk getMessageriePk() {
		return MessageriePk;
	}


	public void setMessageriePk(MessageriePk messageriePk) {
		MessageriePk = messageriePk;
	}


	public User getReceiver() {
		return receiver;
	}


	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}


	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	@Override
	public String toString() {
		return "Message [MessageriePk=" + MessageriePk + ", receiver=" + receiver + ", sender=" + sender + ", Contenu="
				+ Contenu + ", Date_vu=" + Date_vu + ", type_message=" + type_message + "]";
	}

	public type_message getType_message() {
	return type_message;}

	public void setType_message(type_message type_message) {
		this.type_message = type_message;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Date getDate_vu() {
		return Date_vu;
	}

	public void setDate_vu(Date date_vu) {
		Date_vu = date_vu;
	}

	public void setMessagePK(MessageriePk messagePK) {
		MessageriePk = messagePK;
	}

	public String getContenu() {
		return Contenu;
	}

	public void setContenu(String contenu) {
		Contenu = contenu;
	}

}
