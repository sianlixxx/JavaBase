package com.rose.HexOct;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHexOct
{

	/*@Test
	public void test()
	{
		fail("Not yet implemented");
	}*/
	@Test
	public void testToHexString()
	{
		byte[] bytes = {9, 10, 16,};
		
		if("090A10".equals(Convert_byte_array_to_Hex_String.toHexString(bytes)))
		{
			System.out.println("ok");
		}
		
		
	}

}
