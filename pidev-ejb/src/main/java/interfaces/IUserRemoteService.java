package interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.AssetManager;

@Remote
public interface IUserRemoteService {
	AssetManager login(String username, String password);
	void create(AssetManager user);
	Boolean updateUser(AssetManager usr,  int id_manager);
    Boolean removeUser(AssetManager usr);
    List<AssetManager> findAll();
    AssetManager FindById(int id);
    int register(AssetManager e);

}
