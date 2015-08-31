package org.marco.almoco.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;

import org.marco.almoco.model.User;
import org.marco.almoco.model.dao.UserDao;


@Stateful
@LocalBean
public class AutenticationServiceBean implements AutenticationServiceBeanLocal {

	@Inject
	private UserDao userDao;
	
	@Override
    public boolean autenticate(String name, String password) {
		userDao.setUserLogged(new User(name, password));
    	return true;
    }
    
	@Override
    public User getLogedUser() {
		return userDao.getUserLogged();
	}

}
