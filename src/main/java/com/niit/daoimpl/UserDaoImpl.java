package com.niit.daoimpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDao;
import com.niit.model.Cart;
import com.niit.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void insertOrUpdateUser(User user)
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}
	
	public User getUser(String email)
	{
		System.out.println("GetUser");
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, email);
		
		//User user=(User)session.createQuery("from User where name=:name").setString("name",name).uniqueResult();
		
		
		System.out.println(email);
		session.close();
		return user;
	}

	public String getUserName(String email) {
		
		Session session =sessionFactory.openSession();
		String name = (String)session.createQuery("select name from User where email=:email").setString("email", email).uniqueResult();
		System.out.println(name);
		session.close();
		return name;
	}
	
	public String getUserAddress(String email) {
		
		Session session =sessionFactory.openSession();
		String address = (String)session.createQuery("select address from User where email=:email").setString("email", email).uniqueResult();
		System.out.println(address);
		session.close();
		return address;
	}


	public String getUserPhone(String email) {
		
		Session session =sessionFactory.openSession();
		String phone = (String)session.createQuery("select phone from User where email=:email").setString("email", email).uniqueResult();
		System.out.println(phone);
		session.close();
		return phone;
	}
	
	
	
}
