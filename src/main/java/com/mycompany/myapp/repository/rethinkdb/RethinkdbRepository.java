package com.mycompany.myapp.repository.rethinkdb;

import java.io.Serializable;

import javax.inject.Inject;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

public class RethinkdbRepository<S, ID extends Serializable> {
	
//	@Inject
//	RethinkDB rethinkdb;
//	
//	@Inject
//	Connection rethinkdbConnection;
//	
	public void save(S entity) {
//		rethinkdb.db("testdb").table(entity.getClass().getName()).insert(entity).run(rethinkdbConnection);
	}
//	
//	public void delete(S entity) {
//		
//	}

}
