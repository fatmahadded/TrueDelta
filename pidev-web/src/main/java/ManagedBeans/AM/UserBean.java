package ManagedBeans.AM;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Entities.AssetManager;
import interfaces.IUserRemoteService;

@ManagedBean(name = "userbean")
@RequestScoped
public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IUserRemoteService userService;

	private List<AssetManager> users;
	private AssetManager user;

	public UserBean() {

	}

	@PostConstruct
	public void init() {
		users = userService.findAll();
		user = new AssetManager();
	}

	public String create() {
		String navigateTo = "/pages/user/register?faces-redirect=true";

		// user.setEtat(Etat.NotApprouved);
		System.out.println(user.getUsername());
		userService.create(user);
		return navigateTo;
	}

	public AssetManager getUser() {
		return user;
	}

	public void setUser(AssetManager user) {
		this.user = user;
	}

	public List<AssetManager> getUsers() {
		return users;
	}

	public void setUsers(List<AssetManager> users) {
		this.users = users;
	}

}
