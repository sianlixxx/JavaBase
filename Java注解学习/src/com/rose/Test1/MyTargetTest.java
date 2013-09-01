package com.rose.Test1;

import java.lang.reflect.Method;

public class MyTargetTest
{
	@MyTarget
	public void doSomething()
	{
		System.out.println("doSomething");
	}
	
	public static void main(String[] args) throws Exception
	{
		Method method = MyTargetTest.class.getMethod("doSomething", null);
		if(method.isAnnotationPresent(MyTarget.class))
		{
			System.out.println(method.getAnnotation(MyTarget.class));
		}
	}
}
