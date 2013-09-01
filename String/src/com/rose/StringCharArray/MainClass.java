package com.rose.StringCharArray;

public class MainClass
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		//CharAtAndgetChars();
		String str = "To be num one";
		char[] chs = {'a', 'b', 'c'};
		
		System.out.println(String.valueOf(chs));
		System.out.println(String.copyValueOf(chs));
		System.out.println(new String(chs));
		System.out.println(new String(chs, 1, 2));
		char[] chs1 = str.toCharArray();
		for(char ch: chs1)
		{
			System.out.print(ch);
			System.out.println("\n");
		}
		
	}

	/**
	 * Demonstrates the charAt and getChars
	 */
	public static void CharAtAndgetChars()
	{
		String str = "abcdefg";
		char[] chs = new char[7];

		System.out.println("str:");
		for (int i = 0; i < str.length(); i++)
		{
			System.out.printf("%s", str.charAt(i));
		}
		
		str.getChars(0, 7, chs, 0);
		System.out.println("\nThe character array is:");
		for(char character: chs)
		{
			System.out.print(character);
		}
		
	}
}
