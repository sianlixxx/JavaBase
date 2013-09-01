/**
 * ReflectTester.java
 */
package com.miracle.reflectiong;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author tqc 2013-4-18上午12:01:08
 */
public class ReflectTester
{
	public Object copy(Object object) throws Exception
	{
		Class<? extends Object> classType = object.getClass();
		System.out.println("Class:" + classType.getName());
		// 通过默认构造方法创建一个新的对象
		Object objectCopy = classType.getConstructor(new Class[] {})
				.newInstance(new Object[] {});
		Field fields[] = classType.getDeclaredFields();
		for (Field field : fields)
		{
			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			Method setMethod = classType.getMethod(setMethodName,
					new Class[] { field.getType() });
			Object value = getMethod.invoke(object, new Object[] {});
			System.out.println(fieldName + ":" + value);
			setMethod.invoke(objectCopy, new Object[] { value });
		}
		return objectCopy;
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		ReflectTester test = new ReflectTester();
		Customer customer = new Customer("Tom", 21);
		customer.setId(new Long(1));
		Customer customerCopy = (Customer) test.copy(customer);
		System.out.println("Copy information:" + customerCopy.getName() + " "
				+ customerCopy.getAge());
	}
}

class Customer
{
	private Long id;
	private String name;
	private int age;

	// Customer 类是一个 JavaBean
	public Customer()
	{
	}

	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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
