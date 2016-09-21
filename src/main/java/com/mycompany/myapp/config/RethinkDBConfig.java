package com.mycompany.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

/**
 * Created by Seif on 9/21/16.
 */

@Configuration
public class RethinkDBConfig {

    @Bean
    public RethinkDB rethinkDB(){
        RethinkDB r = RethinkDB.r;
        return r;
    }
    
    @Bean
    @DependsOn("rethinkDB")
    public Connection rethinkdbConnection(){
        Connection conn = rethinkDB().connection()
            .hostname("localhost").port(28017).connect();
        return conn;
    }

}
