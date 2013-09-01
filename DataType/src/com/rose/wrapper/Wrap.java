package com.rose.wrapper;

public class Wrap
{
	public static void main(String[] args)
	{
		Integer iob = new Integer(100);
		System.out.println(iob.getClass().getName());
		int i = iob.intValue();
		//int b = Integer.valueOf(i);
		System.out.println(i);
	}
}
