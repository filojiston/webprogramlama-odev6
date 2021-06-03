package com.seid.rest;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class Hibernate {
	private static SessionFactory sessionFactory;
	
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/odev6";
	private static final String USERNAME = "seidoglan";
	private static final String PASSWORD = "seid123";
	private static final String DIALECT = "org.hibernate.dialect.MariaDBDialect";
	
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null)	return sessionFactory;
		
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		
		properties.put(Environment.DRIVER, DRIVER);
		properties.put(Environment.URL, URL);
		properties.put(Environment.USER, USERNAME);
		properties.put(Environment.PASS, PASSWORD);
		properties.put(Environment.DIALECT, DIALECT);
		properties.put(Environment.SHOW_SQL, "true");
		// the default context is 'thread' which means the sesion factory will bind the session to the thread from which openSession(...) is called.
		// https://rbyjava.blogspot.com/2012/05/what-is-currentsessioncontextclass-in.html
		properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		// It is used to validate and exports schema DDL (Data Definition Language) to the database when the SessionFactory is created.
		// If the value is create-drop then, Hibernate first checks for a table and do the necessary operations and
		// finally drops the table after all the operations were completed.
		// https://www.onlinetutorialspoint.com/hibernate/hbm2ddl-auto-example-hibernate-xml-config.html
		//properties.put(Environment.HBM2DDL_AUTO, "create-drop");
		
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(User.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

}
