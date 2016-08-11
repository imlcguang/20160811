package com.ixs.first1.first1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class SessionTest {

	@Test
	public void testOpenSession(){
		Configuration config = new Configuration().configure("model/Hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		if(session!=null)
			System.out.println("yes");
		else
			System.out.println("no");
	}
	
	@Test
	public void testGetCurrentSession(){
		
	}
}
