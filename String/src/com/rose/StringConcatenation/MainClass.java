package com.rose.StringConcatenation;

import javax.naming.ldap.SortControl;

public class MainClass
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String myString = "String is a " + null;
		System.out.println(myString);
		StringReplace();
	}

	public static void StringReplace()
	{
		String org = "This is a test";
		String source = "is";
		String per = "was";
		String result = null;
		int i;
		do
		{
			i = org.indexOf(source);
			if (i != -1)
			{

				result = org.substring(0, i);
				result += per;
				result += org.substring(i + source.length());
				org = result;
			}
		} while (i != -1);
		System.out.println(result);
	}

}
