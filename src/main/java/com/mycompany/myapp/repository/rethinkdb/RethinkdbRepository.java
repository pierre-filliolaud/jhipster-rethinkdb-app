package com.mycompany.myapp.repository.rethinkdb;

import java.io.Serializable;

import javax.inject.Inject;

import com.rethinkdb.RethinkDB;

public class RethinkdbRepository<S, ID extends Serializable> {
	
	@Inject
	RethinkDB rethinkdb;
	
	public void save(S entity) {
		
	}
	
	public void delete(S entity) {
		
	}

}
