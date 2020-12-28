package org.vermeg.bookstore.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.vermeg.bookstore.model.*;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> UserList = session.createQuery("from User").list();
		
		for (User U:UserList) {
			System.out.println("##### Count "+U.getId_User());
		}
		
		return UserList;
	}

	public User getUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User User = (User) session.get(User.class, new Integer(id));
		return User;
	}

	public User addUser(User User) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(User);
		return User;
	}

	public void updateUser(User User) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(User);
	}

	public void deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User User = (User) session.load(User.class, new Integer(id));
		if (null != User) {
			session.delete(User);
		}
	}
	}