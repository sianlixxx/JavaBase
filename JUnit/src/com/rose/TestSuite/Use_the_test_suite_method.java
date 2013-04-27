package com.rose.TestSuite;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class Use_the_test_suite_method extends TestCase
{
	public  static void main(String[] args)
	{
		TestRunner.run(new Use_the_test_suite_method(" ").suite());
	}
	public Use_the_test_suite_method(String method)
	{
		super(method);
	}

	static Test suite()
	{
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestClassOne.class);
		suite.addTest(TestClassTwo.suite());
		return suite;
	}
}

class TestClassOne extends TestCase
{
	public TestClassOne(String method)
	{
		super(method);

	}

	public void testLoneRunner()
	{
		assertEquals(300, 500);
	}
}

class TestClassTwo extends TestCase
{
	public TestClassTwo(String method)
	{
		super(method);

	}

	public void testLongRunner()
	{
		assertEquals(2300, 50);
	}

	public static Test suite()
	{
		TestSuite suite = new TestSuite();
		suite.addTest(new TestClassTwo("testLongRunner"));
		return suite;
	}
}