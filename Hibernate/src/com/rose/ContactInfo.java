package com.rose;

public class ContactInfo
{
	private long id;
	private String firstName;
	private String lastName;
	private PhoneNumber phone;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
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
	public PhoneNumber getPhone()
	{
		return phone;
	}
	public void setPhone(PhoneNumber phone)
	{
		this.phone = phone;
	}
}
