package com.rose.TestSuite;

import java.lang.reflect.Method;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Define_your_own_test_case_runner_with_reflection extends TestCase
{
	@Override
	protected void setUp() throws Exception
	{
		// TODO Auto-generated method stub
		super.setUp();
	}

	public Define_your_own_test_case_runner_with_reflection(String method)
	{
		super(method);
	}

	public void tearDown()
	{
	}

	public void testMe()
	{
		assertTrue(true);
	}

	public static Test suite()
	{
		return new TestSuite(
				Define_your_own_test_case_runner_with_reflection.class);
	}

	public static void main(String[] args)
	{
		TestFinder.run(Define_your_own_test_case_runner_with_reflection.class,
				args);
	}
}

class TestFinder
{

	public static void run(
			Class<Define_your_own_test_case_runner_with_reflection> which,
			String[] args)
	{
		TestSuite suite = null;
		if (args.length != 0)
		{
			try
			{
				java.lang.reflect.Constructor<Define_your_own_test_case_runner_with_reflection> ctor;
				ctor = which.getConstructor(new Class[] { String.class });
				suite = new TestSuite();
				for (int i = 0; i < args.length; i++)
				{
					suite.addTest(ctor.newInstance(new Object[] { args[i] }));
				}
			} catch (Exception e)
			{
				System.err.println("Unable to instantiate " + which.getName()
						+ ": " + e.getMessage());
				System.exit(1);
			}

		} else
		{
			try
			{
				Method suite_method = which.getMethod("suite", new Class[0]);
				suite = (TestSuite) suite_method.invoke(null, null);
			} catch (Exception e)
			{
				suite = new TestSuite(which);
			}
		}
		junit.textui.TestRunner.run(suite);
	}
}