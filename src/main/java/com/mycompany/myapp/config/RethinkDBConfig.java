package com.mycompany.myapp.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycompany.myapp.config.rethinkdb.RethinkDBInitializer;
import com.mycompany.myapp.config.rethinkdb.RethinkProperties;
import com.mycompany.myapp.domain.factory.RethinkDBConnectionFactory;

@Configuration
public class RethinkDBConfig {
	
//    @Inject
    private RethinkProperties rethinkProperties;
    
    // connect to docker
    public static final String DBHOST = "localhost";
    public static final Integer DBPORT = 28015;

    @Bean
    public RethinkDBConnectionFactory connectionFactory() {
        return new RethinkDBConnectionFactory(DBHOST, DBPORT);
    }

    @Bean
    RethinkDBInitializer dbInitializer() {
        return new RethinkDBInitializer();
    }

}
