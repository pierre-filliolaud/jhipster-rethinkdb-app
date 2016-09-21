package com.mycompany.myapp.repository.rethinkdb;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;

import com.mycompany.myapp.domain.factory.RethinkDBConnectionFactory;
import com.rethinkdb.RethinkDB;

public class RethinkdbRepository<S, ID extends Serializable> {
	
	private static final RethinkDB rethinkdb = RethinkDB.r;
	
	@Inject
	private RethinkDBConnectionFactory connectionFactory;
	
	public void save(S entity) {
		String entityClassName = ((Class<?>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
		rethinkdb.db("test").table(entityClassName).insert(entity).run(connectionFactory.createConnection());
	}
	
	public List<S> getEntities() {
		Class clazz = ((Class<?>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		String entityClassName = clazz.getName();
        List<S> entities = (List<S>)rethinkdb.db("test").table(entityClassName)
                .orderBy().optArg("index", rethinkdb.desc("id"))
                .limit(20)
                .orderBy("time")
                .run(connectionFactory.createConnection(), clazz);

        return entities;
	}
//	
//	public void delete(S entity) {
//		
//	}

}
