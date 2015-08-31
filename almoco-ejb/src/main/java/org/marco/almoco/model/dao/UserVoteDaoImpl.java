package org.marco.almoco.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.enterprise.context.ApplicationScoped;

import org.marco.almoco.model.UserVote;

@LocalBean
@ApplicationScoped
public class UserVoteDaoImpl implements UserVoteDao {
	
	private List<UserVote> list;
	
	@PostConstruct
	public void init() {
		list = new ArrayList<UserVote>();
	}
	
	public void add(UserVote uservote) {
		list.add(uservote);
		
	}
	public UserVote getVoteByUser(String name) {
		for (UserVote userVote : list) {
			if( userVote.getUser().getName().compareTo(name) == 0)
				return userVote;
		}
		return null;
	}
	
	public void setList(List<UserVote> list) {
		this.list = list;
	}
	public void deleteAll() {
		this.list.clear();
	}
	
	
}