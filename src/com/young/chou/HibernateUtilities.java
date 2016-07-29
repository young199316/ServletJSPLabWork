package com.young.chou;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {
	private static SessionFactory sessionFactory;
	
	static{
		try{
			 // Create configuration instance
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		}
		catch(HibernateException e){
			System.out.println("Problem creating session Factory!");
			
		}
	}
	
	public static SessionFactory getSesstionFactory(){
		return sessionFactory;
	}
}
