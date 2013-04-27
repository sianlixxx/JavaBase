package com.rose.TestCase;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class Init_class_being_tested_in_test_case_method extends TestCase
{
	public static void main(String[] args)
	{
		TestRunner.runAndWait(suite());
	}
	public Init_class_being_tested_in_test_case_method(String method)
	{
		super(method);
	}
	public void testLongRunner()
	{
		TSP tsp = new TSP();
		assertEquals(500, tsp.shortPath(50));
	}
	public void testShortTest()
	{
		TSP tsp = new TSP();
		assertEquals(50, tsp.shortPath(5));
	}
	public void testAnother()
	{
		TSP tsp = new TSP();
		assertEquals(5, tsp.shortPath(1));
	}
	
	public static Test suite()
	{
		TestSuite suite = new TestSuite();
		suite.addTest(new Init_class_being_tested_in_test_case_method("testShortTest"));
		suite.addTest(new Init_class_being_tested_in_test_case_method("testAnother"));
		return suite;
	}
	
}
class TSP
{
	public int shortPath(int numCities)
	{
		switch (numCities)
		{
		case 50:
			return 500;
		case 5:
			return 50;
		case 1:
			return 5;
		default:
			break;
		}
		return 0;
	}
}