package com.assigment2.database.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory ourSessionFactory;

	static {
		try {

			Configuration configuration = new Configuration();

			configuration.configure();

			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());

			ourSessionFactory = configuration.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return ourSessionFactory;
	}

	public static Session getSession() throws HibernateException {
		return ourSessionFactory.openSession();
	}
}