package com.young.chou;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;


public class LoginService {
	public static boolean isUserAuthenticated(String username, String password){
		User loadeduser = getUserData(username);
		if(loadeduser != null && loadeduser.getPassword().equals(password)){
			return true;
		}
		else{
			return false;
		}

	}
	
	public static List<User> getUsersData(){
		Session session = HibernateUtilities.getSesstionFactory().openSession();		
		session.beginTransaction();
		String hql = "FROM User U";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		session.getTransaction().commit();
		
		return results;
		
	}
	
	public static User getUserData(String username){
		Session session = HibernateUtilities.getSesstionFactory().openSession();		
		session.beginTransaction();
		String hql = "FROM User U WHERE U.username='"+username+"'";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		if(results.size() == 0){
			return null;
		}
		User user= results.get(0);

		session.getTransaction().commit();
		return user;
	}
	
	public static User getUserData_ID(int id){
		Session session = HibernateUtilities.getSesstionFactory().openSession();		
		session.beginTransaction();
		String hql = "FROM User U WHERE U.id='"+id+"'";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		if(results.size() == 0){
			return null;
		}
		User user= results.get(0);

		session.getTransaction().commit();
		return user;
	}
	
	public static User registerUser(String username, String password){
		Session session = HibernateUtilities.getSesstionFactory().openSession();		
		session.beginTransaction();
		String hql = "FROM User U WHERE U.username='"+username+"'";
		Query<User> query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		if(results.size() == 0){
			User user =  new User(username, password);
			session.save(user);
			session.getTransaction().commit();
			return user;
		}
		else{
			return null;
		}
	}
}
