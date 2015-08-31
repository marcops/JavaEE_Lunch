package org.marco.almoco.service;

import javax.ejb.Local;

import org.marco.almoco.model.User;

@Local
public interface AutenticationServiceBeanLocal {

	boolean autenticate(String name, String passwowd);

	User getLogedUser();

}
