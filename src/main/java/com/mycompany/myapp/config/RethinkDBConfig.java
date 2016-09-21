package com.mycompany.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        Connection conn = r.connection()
            .hostname("localhost").port(28017).connect();
        return r;
    }

}
