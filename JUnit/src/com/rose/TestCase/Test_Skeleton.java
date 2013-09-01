package com.rose.TestCase;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class Test_Skeleton extends TestCase
{
	public void setUp()
	{
		
	}
	public void tearDown()
	{
		
	}
	
	public Test_Skeleton(String name)
	{
		super(name);
	}
	
	public static Test suite()
	{
		return new TestSuite(Test_Skeleton.class);
	}
	
	public static void main(String[] args)
	{
		TestSuite suite = new TestSuite();
		if(args.length != 0)
		{
			for(int i = 0; i < args.length; i++)
			{
				suite.addTest(new Test_Skeleton(args[i]));
			}
		}
		else
		{
			suite.addTest(Test_Skeleton.suite());
		}
		TestRunner.run(suite);
	}
}
