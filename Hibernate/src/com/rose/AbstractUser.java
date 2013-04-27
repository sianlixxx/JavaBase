package com.rose;

import java.io.Serializable;

public class AbstractUser implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private long dateCreated;
	
	public AbstractUser()
	{
		
	}
	public AbstractUser(Integer id, String username, String password,
			String firstName, String lastName, long dateCreated)
	{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateCreated = dateCreated;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public long getDateCreated()
	{
		return dateCreated;
	}
	public void setDateCreated(long dateCreated)
	{
		this.dateCreated = dateCreated;
	}
}
