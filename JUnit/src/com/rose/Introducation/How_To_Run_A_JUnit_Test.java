package com.rose.Introducation;

import junit.framework.TestCase;

public class How_To_Run_A_JUnit_Test extends TestCase
{
	public How_To_Run_A_JUnit_Test(String name)
	{
		super(name);
	}
	public void testOrder2()
	{
		int[] array = new int[3];
		array[0] = 9;
		array[1] = 4;
		array[2] = 10;
		assertEquals(10, Largest.largest(array));
	}
	
	public void testAdd()
	{
		assertEquals(5, 2 + 3);
		assertEquals(5, 9 - 4);
	}
	
	
}
class Largest
{
	public static int largest(int[] list)
	{
		int index, max = Integer.MIN_VALUE;
		for(index = 0; index < list.length; index++)
		{
			if(max < list[index])
			{
				max = list[index];
			}
		}
		return max;
	}
}