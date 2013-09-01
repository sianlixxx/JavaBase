package com.rose.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Decompile
{

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException
	{
		decompileClass(Class.forName("java.lang.String"), 0);

	}

	static void decompileClass(Class<?> clazz, int indentLevel)
	{
		System.out.println(Modifier.toString(clazz.getModifiers()));
		if(clazz.isEnum())
		{
			System.out.println("enum" + clazz.getName());
		}else if(clazz.isInterface())
		{
			if(clazz.isAnnotation())
			{
				System.out.println("@");
			}
			System.out.println(clazz.getName());
		}
		else
		{
			System.out.println(clazz);
		}
		
		System.out.println("{");
		Field[] fields = clazz.getFields();
		System.out.println("Fields");
		
		for(Field field: fields)
		{
			System.out.println(field);
		}
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		if(fields.length != 0 && constructors.length != 0 )
		{
			System.out.println();
		}
		
		for(Constructor<?> constructor : constructors)
		{
			System.out.println(constructor);
		}
		
		Method[] methods = clazz.getDeclaredMethods();
		if(methods.length != 0 && (constructors.length != 0 || fields.length != 0))
		{
			System.out.println();
		}
		
		for(Method method: methods)
		{
			System.out.println(method);
		}
		
		Method[] allMethods = clazz.getMethods();
		if(allMethods.length != 0 && (methods.length != 0 || fields.length != 0 || constructors.length != 0))
		{
			System.out.println();
		}
		for(Method method: allMethods)
		{
			System.out.println(method);
		}
		
		Class<?>[] members = clazz.getDeclaredClasses();
		if(members.length != 0 && (fields.length != 0 && constructors.length != 0 || methods.length != 0 || allMethods.length != 0))
				{
			System.out.println();
				}
		for(int i = 0; i < members.length; i++)
		{
			if(clazz != members[i])
			{
				decompileClass(members[i], indentLevel + 1);
				if(i != members.length - 1)
				System.out.println();
			}
		}
		
		System.out.println("}");
			
		
	}

}
