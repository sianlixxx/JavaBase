package com.miracle.clone;

import java.io.Serializable;
import java.util.Date;

public class User implements Cloneable, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	public User(String username, String password, Date birthdate)
	{
		this.username = username;
		this.password = password;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	@Override
	public int hashCode()
	{
		return 0;
		// 省略equals的实现(可用eclipse自动生成)
	}

	@Override
	public boolean equals(Object obj)
	{
		User tmp = (User)obj;
		if (this == obj)
		{
			return true;
		}
		if (this.password.equals(tmp.password)
				&& this.username.equals(tmp.username)
				/*&& this.birthdate.equals(tmp.birthdate)*/)
		{
			return true;
		}
		return false;
	}

	// 省略一大堆get/set方法

	public static void main(String[] args) throws CloneNotSupportedException
	{
		User u1 = new User("Kent", "123456", new Date());
		User u2 = u1;
		User u3 = (User) u1.clone();
		System.out.println(u1 == u2); // true
		System.out.println(u1.equals(u2)); // true
		System.out.println(u1 == u3); // false
		System.out.println(u1.equals(u3)); // 这个比较需要重写equals方法
	}
}
