package com.rose.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Introduction
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Class c = Class.forName("java.awt.Dimension");
			System.out.println("Constructos");
			Constructor<String>[] constructors = c.getConstructors();
			for (Constructor<String> tmpc : constructors)
			{
				System.out.println(tmpc);
			}
			System.out.println("Fields");
			Field[] fields = c.getFields();
			for (Field field : fields)
			{
				System.out.println(field);
			}
			System.out.println("Method");
			Method[] methods = c.getMethods();
			for (Method method : methods)
			{
				System.out.println(method);
			}

		} catch (Exception e)
		{
			System.out.println("Exception:" + e);
		}
	}

}
