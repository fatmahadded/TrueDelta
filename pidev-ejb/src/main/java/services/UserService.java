package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.AssetManager;
import interfaces.IUserLocalService;
import interfaces.IUserRemoteService;

@Stateless
public class UserService  implements IUserLocalService , IUserRemoteService{

	@PersistenceContext
	EntityManager em;
	
	private AssetManager user;
	
	@Override
	public AssetManager login(String username, String password) {
		
		AssetManager u=null;
		Query q=em.createQuery("select u from AssetManager u where u.username=:p1 and u.password=:p2");
		q.setParameter("p1", username);
		q.setParameter("p2",password);
		try {
			u = (AssetManager) q.getSingleResult();

		} catch (Exception e) {

			System.out.println("error " + e.getMessage());
		}
		user =u ;
		return u;
	}
	
	@Override
	public int register(AssetManager e) {
		em.persist(e);
		return e.getIdManager();

	}

	@Override
	public void create(AssetManager user) {
		em.persist(user);
		
	}

	@Override
	public Boolean updateUser(AssetManager usr,  int id_manager) {
		Query query =  em.createQuery("update AssetManager u set username=:username , lastname=:lastname , code=:code   where u.idManager=:id_manager ");
		query.setParameter("username", usr.getUsername());
		query.setParameter("lastname", usr.getLastname());
		query.setParameter("code", usr.getCode());
		query.setParameter("id_manager", id_manager);
		int m=query.executeUpdate();
	   return true;
	}

	@Override
	public Boolean removeUser(AssetManager usr) {
		AssetManager u = em.find(AssetManager.class, usr);
		em.remove(u);
		return true;
	}

	@Override
	public List<AssetManager> findAll() {
		return  em.createQuery("select d from AssetManager d", AssetManager.class).getResultList();
	}

	@Override
	public AssetManager FindById(int id) {
		AssetManager user;
		Query q=em.createQuery("select u from AssetManager u where u.id=:p1 ");
		q.setParameter("p1", id);
		user = (AssetManager) q.getSingleResult();
		
		return user;
	}

}
