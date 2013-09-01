package com.rose;

public class AnnotationTest
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		System.runFinalizersOnExit(true);
		sayHello();
	}
	@Deprecated
	public static void sayHello()
	{
		
	}
}
