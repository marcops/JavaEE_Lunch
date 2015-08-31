package org.marco.almoco.facade;

import org.marco.almoco.model.User;

public interface LoginFacade {
	public boolean autenticate(String user, String passw);

	public boolean userVoted(String user);
	
	public User getLogedUser();
}
