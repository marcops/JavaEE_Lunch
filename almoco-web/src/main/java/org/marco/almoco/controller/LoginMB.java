package org.marco.almoco.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.marco.almoco.facade.LoginFacade;

@Named("loginMBean")
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = -3883797822941666276L;

	@Inject
	private LoginFacade loginFacade;

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		if (loginFacade.autenticate(getName(), getPassword())) {
			boolean voted = loginFacade.userVoted(getName());
			if (voted) {
				return "alreadyVoted";
			} else {
				return "success";
			}
		}
		return "failure";
	}

}
