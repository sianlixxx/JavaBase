package com.rose.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class CreateStringwithchararray
{
	public static void main(String[] args) throws IOException
	{
		reverString();
		AssignStringVariableToNull();
		ToLowerCaseAndToUpperCase();
		ComparingTwoStrings();
		UsingTrim();

	}

	private static void reverString()
	{
		String palindrome = "Dot say i was Tod";
		int len = palindrome.length();
		char[] tmp = new char[len];
		char[] result = new char[len];
		for (int i = 0; i < len; i++)
		{
			tmp[i] = palindrome.charAt(i);
		}
		for (int i = 0; i < len; i++)
		{
			result[i] = tmp[len - i - 1];
		}
		String str = new String(result);
		System.out.println(str);
	}

	public static void AssignStringVariableToNull()
	{
		String tmp = null;
		System.out.println(tmp);

		// java.lang.NullPointerException
		// System.out.println(tmp.length());
	}

	public static void ToLowerCaseAndToUpperCase()
	{
		String s1 = new String("hello");
		String s2 = new String("GOODBYE");
		String s3 = new String("   spaces   ");

		System.out.printf("s1 = %s\ns2 = %s\ns3 = %s\n\n", s1, s2, s3);
		System.out.println("s1.toUpperCase" + s1.toUpperCase());
		System.out.println("s2.toLowperCase" + s2.toLowerCase());
	}

	public static void ComparingTwoStrings()
	{
		String str1 = "hello";
		String str2 = "HELLo";
		if (str1.equals(str2.toLowerCase()))
		{
			System.out.println("==");
		}
		System.out.println(str1.concat(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}

	public static void UsingTrim() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String stop;
		do
		{
			stop = br.readLine();
			line = stop.trim();
			System.out.println(line);
		} while (!stop.equals("stop"));
		StringBuffer test = new StringBuffer("abc");
		System.out.println("abc".contentEquals(test));
		System.out.println("abc".equals(test));
		System.out.println("abc".equals(test.toString()));
	}

}
