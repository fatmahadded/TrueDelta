package services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Messagerie;
import Entities.User;
import interfaces.IMessageServiceLocal;
import interfaces.IMessageServiceRemote;

@Stateless
public class ServiceMessages implements IMessageServiceLocal, IMessageServiceRemote {
	@PersistenceContext(unitName = "PiDbDS")
EntityManager em;
	
	@Override
	public int addMessage(Messagerie msg) {
		em.persist(msg);
		System.out.println("Out of addUser" + msg.getMessageriePk().getId_sender());
		return msg.getMessageriePk().getId_sender();
	}

	@Override
	public void removeMessage(int id) {
		em.remove(em.find(Messagerie.class, id));
		
	}

		@Override
	public Messagerie findMessageById(int id) {
			User u = em.find(User.class,id);
			List<Messagerie> msgs = em.createQuery("from Messagerie where id_receiver="+u.getId(), Messagerie.class).getResultList();  
		    return null;
	}

	@Override
	public void removeConversation(int id) {
		em.remove(em.find(Messagerie.class, id));		
	}

	@Override
	public List<Messagerie> findInbox(int id) {
		User u = em.find(User.class,id);
		List<Messagerie> msgs = em.createQuery("from Messagerie where type_message='inbox' and id_receiver="+u.getId(), Messagerie.class).getResultList();  
	    return msgs;
	}

	@Override
	public List<Messagerie> findStarredById(int id) {
		User u = em.find(User.class,id);
		List<Messagerie> msgs = em.createQuery("from Messagerie where type_message='starred' and id_receiver="+u.getId(), Messagerie.class).getResultList();  
	    return msgs;
	}

	@Override
	public List<Messagerie> findSentById(int id) {
		User u = em.find(User.class,id);
		List<Messagerie> msgs = em.createQuery("from Messagerie where type_message='sent' and id_receiver="+u.getId(), Messagerie.class).getResultList();  
	    return msgs;
	}

	@Override
	public List<Messagerie> findDraftsById(int id) {
		User u = em.find(User.class,id);
		List<Messagerie> msgs = em.createQuery("from Messagerie where type_message='drafts' and id_receiver="+u.getId(), Messagerie.class).getResultList();  
	    return msgs;
	}

	@Override
	public List<Messagerie> findImportantById(int id) {
		User u = em.find(User.class,id);
		List<Messagerie> msgs = em.createQuery("from Messagerie where type_message='important' and id_receiver="+u.getId(), Messagerie.class).getResultList();  
	    return msgs;
	}

	@Override
	public User findUserById(int id) {
		User u = em.find(User.class,id);
		return u;
	}

	@Override
	public User findUserByEmail(String email) {
		User u = em.find(User.class,email);
		return u;
	}

}
