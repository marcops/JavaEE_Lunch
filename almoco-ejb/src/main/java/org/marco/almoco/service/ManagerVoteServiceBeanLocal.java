package org.marco.almoco.service;

import javax.ejb.Local;

import org.marco.almoco.model.UserVote;

@Local
public interface ManagerVoteServiceBeanLocal {

	boolean userVoted(String name);

	boolean computeUserVote(UserVote user);

}
