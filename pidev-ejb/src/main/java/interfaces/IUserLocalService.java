package interfaces;

import Entities.User;

public interface IUserLocalService {
	public User login(String username, String password);
}
