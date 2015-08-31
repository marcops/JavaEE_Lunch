package org.marco.almoco.model.dao;

import org.marco.almoco.model.UserVote;

public interface UserVoteDao {
	public void add(UserVote uservote);

	public UserVote getVoteByUser(String name);

	public void deleteAll();
}