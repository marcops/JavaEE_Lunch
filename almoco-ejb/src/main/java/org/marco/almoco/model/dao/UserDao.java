package org.marco.almoco.model.dao;

import org.marco.almoco.model.User;


public interface UserDao {
	public void setUserLogged(User user);

	public User getUserLogged();
}