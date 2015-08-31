package org.marco.almoco.facade;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.marco.almoco.model.User;
import org.marco.almoco.service.AutenticationServiceBeanLocal;
import org.marco.almoco.service.ManagerVoteServiceBeanLocal;


@Stateless
public class LoginFacadeBean implements LoginFacade {

	@Inject
	private AutenticationServiceBeanLocal autenticationServiceBeanLocal;

	@Inject
	private ManagerVoteServiceBeanLocal votingServiceBeanLocal;
	

	public boolean autenticate(String user, String passw) {
		return autenticationServiceBeanLocal.autenticate(user, passw);
	}

	public boolean userVoted(String user) {
		return votingServiceBeanLocal.userVoted(user);
	}

	@Override
	public User getLogedUser() {
		return autenticationServiceBeanLocal.getLogedUser();
	}
}
