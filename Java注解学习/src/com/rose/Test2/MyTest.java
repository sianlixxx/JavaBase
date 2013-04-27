package com.rose.Test2;

@MyAnnotation(hello = "beijing", world ="shanghai", array = {}, style = int.class)
public class MyTest
{
	@MyAnnotation(world="shanghai", array={1, 2, 3})
	@Deprecated
	@SuppressWarnings("")
	public void outPut()
	{
		System.out.println("output something");
	}
}
