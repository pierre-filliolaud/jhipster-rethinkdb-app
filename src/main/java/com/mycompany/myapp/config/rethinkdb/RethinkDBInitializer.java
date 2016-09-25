package com.mycompany.myapp.config.rethinkdb;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.domain.factory.RethinkDBConnectionFactory;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

public class RethinkDBInitializer implements InitializingBean {
	
	public static final String DBNAME = "rethinkdbjhipster";
	
    @Autowired
    private RethinkDBConnectionFactory connectionFactory;
    
//    @Inject
//    private RethinkProperties rethinkProperties;
    
    private static final RethinkDB r = RethinkDB.r;

    @Override
    public void afterPropertiesSet() throws Exception {
        createDb();
    }

    private void createDb() {
        Connection connection = connectionFactory.createConnection();
        List<String> dbList = r.dbList().run(connection);
        if (!dbList.contains(DBNAME)) {
            r.dbCreate(DBNAME).run(connection);
        }
        List<String> tables = r.db(DBNAME).tableList().run(connection);
        if (!tables.contains("product")) {
            r.db(DBNAME).tableCreate("product").run(connection);
            r.db(DBNAME).table("product").indexCreate("name").run(connection);
            r.db(DBNAME).table("product").indexCreate("price").run(connection);
        }
    }

}
