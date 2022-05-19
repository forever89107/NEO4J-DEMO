package com.example.neo4jdemo.neo4j;

import org.neo4j.ogm.metadata.reflect.EntityFactory;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class Neo4jSessionFactory {
//    private final static Configuration = ... // provide configuration as seen before
    private final static SessionFactory sessionFactory = new SessionFactory();
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }
    // prevent external instantiation
    private Neo4jSessionFactory() {
    }

    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}
