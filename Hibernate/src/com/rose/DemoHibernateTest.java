package com.rose;

import org.hibernate.Transaction;

public class DemoHibernateTest
{
	public static void main(String[] args)
	{
		addUser();
		
	}

	private static void printUser(String extraText, User user)
	{
		System.out.println(extraText + "User[Username: " + user.getUsername()
				+ ", Password:" + user.getPassword() + ",First Name: "
				+ user.getFirstName() + ",Last Name: " + user.getLastName()
				+ "]");
	}

	private static void addUser()
	{
		User user = new User();
		user.setId(1);
		user.setUsername("guoqiang");
		user.setFirstName("guo");
		user.setLastName("qiang");
		user.setPassword("guoqiang");
		user.setDateCreated(System.currentTimeMillis());
		// Create DAO
		UserDAO dao = new UserDAO();
		dao.addUser(user);
		/*// Start the transaction
		Transaction tx = dao.getSession().beginTransaction();
		// Add user
		dao.save(user);
		// Commit the transaction
		tx.commit();
		// Close the session
		dao.getSession().close();*/
	}
/*
	private static void listUser()
	{
		UserDAO dao = new UserDAO()
		User user = dao.fndById(1);
		 printUser("Pringting User, ", user);
	       dao.getSession().close();
	}

	private static void changeUser()
	{
		UserDAO dao = new UserDAO();
		User user = dao.findById(1);
		user.setUsername("test");
		user.setPassword("test");
		user.setFirstName("demo");
		user.setLastName("demo");

		Transaction tx = dao.getSession().beginTransaction();
		// Add user
		dao.save(user);
		// Commit the transaction
		tx.commit();

		User updateUser = dao.findById(1);
		printUser("Pringting Updated User, ", updateUser);
		dao.getSession().close();
	}*/

}
