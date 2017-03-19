package com.sellProduct.oracle;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ConnectionProvider {

	public static void main(String[] args) {  
		ConnectionProvider obj=new ConnectionProvider();
		SessionFactory factory=obj.buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Users.class);
		List<Users> results = cr.list();
		
	      
	}  
	
	
	private  final SessionFactory sessionFactory = buildSessionFactory();

	public   SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public  SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public  void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
