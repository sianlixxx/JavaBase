package com.rose;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Administrator implements Cloneable, Serializable
{
	private User user;
	private Boolean editable;

	public Administrator(User user, Boolean editable)
	{
		this.setUser(user);
		this.editable = editable;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		Administrator tmp =  (Administrator)super.clone();
		tmp.user = (User)this.user.clone();
		return tmp;
	}

	@Override
	public int hashCode()
	{
		return 0;
		// 老规矩
	}

	@Override
	public boolean equals(Object obj)
	{
		Administrator tmp = (Administrator)obj;
		if( tmp == this)
		{
			return true;
		}
		if(!(tmp.user.equals(this.user) && (tmp.editable == this.editable)))
		{
			return true;
		}
		
		return false;
	}

	// 老规矩
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public static void main(String[] args) throws CloneNotSupportedException
	{
		Administrator a1 = new Administrator(new User("Kent", "123456",
				new Date()), true);
		Administrator a2 = a1;
		Administrator a3 = (Administrator) a1.clone();
		System.out.println(a1 == a2); // true
		System.out.println(a1.equals(a2)); // true
		System.out.println(a1 == a3); // false
		System.out.println("a1 equals a3 :" + a1.equals(a3)); // 这个比较需要重写方法
		System.out.println(a1.getUser() == a3.getUser()); // true 
		System.out.println(a1.getUser().equals(a3.getUser())); // true
	}

}
