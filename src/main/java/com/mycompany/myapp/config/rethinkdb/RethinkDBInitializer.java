package com.mycompany.myapp.config.rethinkdb;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.domain.factory.RethinkDBConnectionFactory;
import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

public class RethinkDBInitializer implements InitializingBean {
	
    @Autowired
    private RethinkDBConnectionFactory connectionFactory;
    
    private static final RethinkDB r = RethinkDB.r;

    @Override
    public void afterPropertiesSet() throws Exception {
        createDb();
    }

    private void createDb() {
        Connection connection = connectionFactory.createConnection();
        List<String> dbList = r.dbList().run(connection);
        if (!dbList.contains("test")) {
            r.dbCreate("test").run(connection);
        }
        List<String> tables = r.db("test").tableList().run(connection);
        if (!tables.contains("product")) {
            r.db("test").tableCreate("product").run(connection);
            r.db("test").table("product").indexCreate("id").run(connection);
        }
    }

}
