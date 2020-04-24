package Services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.User;
import Interfaces.IUserLocalService;

public class UserService implements IUserLocalService{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public User login(String username, String password) {
		User user = em.createQuery("select u from User u where username=:username and password=:password",User.class).setParameter("username", username).setParameter("password", password).getSingleResult();
		return user;
	}

}
