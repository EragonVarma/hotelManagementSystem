package idb.hms.services;

import idb.hms.entity.User;

public interface LoginService {

	public User getUser (String login);
	
	public User loginUser(String login, String password);
	
}






