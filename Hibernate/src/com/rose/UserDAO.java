package com.rose;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO
{
	public boolean hasUser(String username)
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Users where name=:name");
		query.setString("name", username);
		if (query.list().size() > 0)
			return true;
		session = null;
		tx.commit();
		return false;
	}

	public User getUser(String username)
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Users where name=:name");
		query.setString("name", username);
		User user = new User();
		user = (User) query.uniqueResult();
		session = null;
		tx.commit();
		return user;
	}

	public void addUser(User user) throws HibernateException
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		session.flush();
		session.clear();
		tx.commit();
	}

	public void deleUser(User user) throws HibernateException
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		session.flush();
		session.clear();
		tx.commit();
	}
}