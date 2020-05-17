package interfaces;


import javax.ejb.Remote;

import Entities.User;

@Remote
public interface IUserServiceRemote {
	public User login(String username, String password);

	
	

}
