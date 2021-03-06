package com.rose.TestSuite;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class Test_suite extends TestCase
{
	
	public void main(String[] args)
	{
		//TestRunner.run(new TestClassComposite("").suite());
		//TestRunner.run(new TestClassTwo("").suite());
		TestRunner.run(TestClassComposite.suite());
	}
	public Test_suite(String method)
	{
		super(method);
	}
	public void testAddition()
	{
		assertEquals(4, 2 + 2);
	}
	static class TestClassTwo extends TestCase
	{
		public TestClassTwo(String method)
		{
			super(method);
		}
		
		public void testLongRunner()
		{
			assertEquals(200, 100);
		}
		
		public static Test suite()
		{
			TestSuite suite = new TestSuite();
			suite.addTest(new TestClassTwo("testLongRunner"));
			//suite.addTest(new Test_suite("testAddition"));
			return suite;
		}
	}
	static class TestClassComposite extends TestCase
	{
		public TestClassComposite(String method)
		{
			super(method);
		}
		public static Test suite()
		{
			TestSuite suite = new TestSuite();
			suite.addTestSuite(Test_suite.class);
			suite.addTestSuite(TestClassTwo.class);
			return suite;
		}
	}
	
}
