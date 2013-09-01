package com.rose.Assert;

import static org.junit.Assert.*;

import java.util.regex.Matcher;

import org.junit.Test;

public class Ensure_that_they_are_equal
{
	@Test
	public void testOrder2()
	{
		int[] arr = new int[3];
		arr[0] = 8;
		arr[1] = 9;
		arr[2] = 7;
		assertEquals(9, Largest.largest(arr));
	}
	
	@Test
	public void testEmpty()
	{
		assertEquals("Should be 3 1/3", 3.33, 10.0/3.0, 0.0001);
	}
	
	@Test
	public void testEmpty1()
	{
		assertNull("it should be null", null);
	}
	
	@Test
	public void testEmpty2() {

	    assertSame("should be same", "actual", "actual");

	  }
	@Test
	 public void testEmpty4() {

		    assertNotSame("should be same", "expected", "actual");

		  }
	@Test
	public void testEmpty5()
	{
		assertTrue("should be true", true);
	}
	
	@Test
	public void testEmpty6()
	
	{
		assertFalse("should be false", false);
	}
	
	@Test
	public void testEmpty7()
	{
		//Matcher matcher = ne
		assertThat("null", null);
	}
}

class Largest
{
	public static int largest(int[] list)
	{
		int index, max = Integer.MIN_VALUE;
		for (index = 0; index < list.length; index++)
		{
			if (list[index] > max)
			{
				max = list[index];

			}
		}
		return max;
	}
}
