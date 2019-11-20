package com.bid.app.server.hibernate;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.bid.app.server.bootstrap.GenericContainer;


public class BaseDataAccessObject {

	private static final ThreadLocal session = new ThreadLocal();
	private static final Logger log = Logger.getAnonymousLogger();
	private static SessionFactory sessionFactory;
	private String hibarnatePropertyFile;

	public Session getSession() {
		Session session = (Session) BaseDataAccessObject.session.get();
		if (session == null) {
			sessionFactory = GenericContainer.getCurrentContainer().getSessionFactory();
			session = sessionFactory.openSession();
			BaseDataAccessObject.session.set(session);
		}
		return session;
	}

	protected void begin() {
		getSession().beginTransaction();
	}

	protected void commit() {
		getSession().getTransaction().commit();
	}

	protected void rollback() {
		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot rollback", e);
		}
		try {
			getSession().close();
		} catch (HibernateException e) {
			log.log(Level.WARNING, "Cannot close", e);
		}
		BaseDataAccessObject.session.set(null);
	}

	public  void close() {
		getSession().close();
		BaseDataAccessObject.session.set(null);
	}

}
