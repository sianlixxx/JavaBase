package com.rose.Cast;

public class Convert_an_integer_into_binary_hexadecimal_and_octal
{
	public static void main(String args[])
	{
		int num = 16;

		System.out.println(num + " in binary: " + Integer.toBinaryString(num));

		System.out.println(num + " in octal: " + Integer.toOctalString(num));

		System.out.println(num + " in hexadecimal: " + Integer.toHexString(num));
		
	}
}
