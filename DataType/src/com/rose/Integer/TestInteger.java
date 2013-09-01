package com.rose.Integer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInteger
{

	/*@Test
	public void test()
	{
		fail("Not yet implemented");
	}*/
	@Test
	public void testhumanReadableInt()
	{
		char[] temp = "9.8k".toCharArray();
		char[] temp1 =  Stringutils.humanReadableInt(10000).toCharArray();
		
		assertArrayEquals("just test", temp, temp1);
		
		
	}
	@Test
	public void testInt2byte()
	{
		int[] tem = {1};
		byte[] tem2 = {1,0,0,0};
		assertArrayEquals(tem2, ArrayCopy.int2byte(tem));
	}

}
