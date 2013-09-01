package com.rose.LogFilter;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomFilter
{
	private String name = null;
	private int age;
	public CustomFilter(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
}
class AgeFilter implements Filter
{
	public boolean isLoggable(LogRecord record)
	{
		boolean result = false;
		Object[] objs = record.getParameters();
		CustomFilter person = (CustomFilter) objs[0];
		if(person != null)
		{
			int age = person.getAge();
			if(age > 30)
				result = true;
			else
				result = false;
		}
		return result;
	}
}


