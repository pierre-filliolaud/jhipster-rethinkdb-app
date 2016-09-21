package com.mycompany.myapp.config;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.rethinkdb.RethinkDB.r;

/**
 * Created by Seif on 9/21/16.
 */

@Configuration
public class RethinkDBConfig {

    @Bean
    public RethinkDB rethinkDB(){
        RethinkDB r = RethinkDB.r;
        Connection conn = r.connection()
            .hostname("localhost").port(28015).connect();
        // Find the odd numbers, multiply each by 2, and add the total
        Long output = r.range(10)
            .filter(x -> x.mod(2).eq(1))
            .map(x -> x.mul(2)).sum().run(conn);
        return r;
    }

}
