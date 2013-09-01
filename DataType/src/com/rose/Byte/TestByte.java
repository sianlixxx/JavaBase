package com.rose.Byte;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestByte
{
	@Test
	public void testConvertByteToString()
	{
		
		String str = "A";
		String tmp = Convert.convertByteToString((byte)65);
		assertArrayEquals(str.toCharArray(), tmp.toCharArray());
	}
	@Test
	public void testconvertStringToByet()
	{
		byte tmp = (byte)65;
		if(tmp == Convert.convertStringToByte("65"))
		{
			System.out.println("ok");
		}
		else
		{
			System.out.println("No");
		}
	}
	@Test
	public void testArrayEquals()
	{
		byte[] a1 = new byte[] { 7, 25, 12 };
	    byte[] a2 = new byte[] { 7, 2, 12 };
		char[] ch1 = "ok".toCharArray();
		char[] ch2 = Convert.arrayEquals(a1, a2).toCharArray();
		assertArrayEquals(ch1, ch2);
	}
}
