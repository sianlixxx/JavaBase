package com.rose;

import java.io.Serializable;

public class User extends AbstractUser implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User(Integer id, String username, String password, String firstName,
			String lastName, long dateCreated)
	{
		super(id, username, password, firstName, lastName, dateCreated);
		
	}
	public User()
	{
		
	}
	
}
