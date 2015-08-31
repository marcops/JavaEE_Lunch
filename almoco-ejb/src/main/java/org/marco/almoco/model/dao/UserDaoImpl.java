package org.marco.almoco.model.dao;

import javax.ejb.LocalBean;
import javax.enterprise.context.ApplicationScoped;

import org.marco.almoco.model.User;

@LocalBean
@ApplicationScoped
public class UserDaoImpl implements UserDao {

	private User logged;

	@Override
	public void setUserLogged(User user) {
		logged = user;
	}

	@Override
	public User getUserLogged() {
		return logged;
	}

}