package com.rose.Integer;

import java.math.BigInteger;

public class BigIntegerNew
{
	public static void main(String[] argv) throws Exception
	{
		int radix = 16;
		BigInteger bi = new BigInteger("16", radix);
		String s = bi.toString(radix);
		System.out.println(bi +"\n" + s);
		
		BigInteger bi1 = new BigInteger("65", 10);
		byte[] bytes = bi1.toByteArray();
		for(int i = 0; i < bytes.length; i++)
		{
			System.out.println(bytes[i]);
		}
		System.out.println("***" + bi1 + "\n" + new String(bytes).toString());
		
		BigInteger n = new BigInteger("1000000000000");
		BigInteger one = new BigInteger("1");
		while (!n.isProbablePrime(7))
			n = n.add(one);
		System.out.println(n.toString(10) + " is probably prime.");
		System.out.println("It is " + n.bitLength() + " bits in length.");
	}
}
