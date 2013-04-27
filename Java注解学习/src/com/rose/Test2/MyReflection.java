package com.rose.Test2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflection
{
	public static void  main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		MyTest myTest = new MyTest();
		Class<MyTest> c = MyTest.class;
		Method method = c.getMethod("outPut", new Class[]{});
		if(MyTest.class.isAnnotationPresent(MyAnnotation.class))
		{
			System.out.println("have annotation       " + myTest.getClass().getAnnotation(MyAnnotation.class));
		}
		
		if(method.isAnnotationPresent(MyAnnotation.class))
		{
			System.out.println("have annotation       " + method.getAnnotation(MyAnnotation.class));
			method.invoke(myTest, null);
			MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
			String hello = myAnnotation.hello();
			String world = myAnnotation.world();
			System.out.println(hello + ",    " + world + ",    "+ myAnnotation.array().length + ",   "+ myAnnotation.style());
		}
		
		Annotation[] annotations = method.getAnnotations();
		for(Annotation annotation: annotations)
		{
			System.out.println(annotation.annotationType().getName());
		}
		
	}
}
