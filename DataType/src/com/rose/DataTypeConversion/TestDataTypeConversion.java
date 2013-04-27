package com.rose.DataTypeConversion;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDataTypeConversion
{

	/*@Test
	public void test()
	{
		fail("Not yet implemented");
	}*/

	@Test
	public void testByteToInt()
	{
		int i = 16;
		
		byte[] bt = new byte[4];
		Utils.putInt(i, bt, 0);
		//assertEquals(new byte[]{1,1,1,1}, bt);
		assertArrayEquals(new byte[]{0, 0, 0, 16}, bt);
	}

}
