package com.mycompany.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycompany.myapp.config.rethinkdb.RethinkDBInitializer;
import com.mycompany.myapp.domain.factory.RethinkDBConnectionFactory;

@Configuration
public class RethinkDBConfig {
    
    // connect to docker
    public static final String DBHOST = "localhost";
    public static final Integer DBPORT = 28017;

    @Bean
    public RethinkDBConnectionFactory connectionFactory() {
        return new RethinkDBConnectionFactory(DBHOST, DBPORT);
    }

    @Bean
    RethinkDBInitializer dbInitializer() {
        return new RethinkDBInitializer();
    }

}
