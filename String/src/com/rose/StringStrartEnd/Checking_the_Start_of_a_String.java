package com.rose.StringStrartEnd;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import org.w3c.dom.ls.LSException;

public class Checking_the_Start_of_a_String
{
	private static final String EOL = System.getProperty("line.separator");
	public static void main(String[] args)
	{
		Checking_the_Start_of_a_String tmp = new Checking_the_Start_of_a_String();
		tmp.TestStart();
		tmp.TestEnd();
		System.out.println(tmp.chop("abcdefghigk\nlmnopqrst", 2));
		System.out.println(tmp.chomp("abcdefg", "efg"));
		
	}
	public void TestStart()
	{
		String str = "bac";
		if(str.startsWith("ba"))
		{
			System.out.println(true);
		}
	}
	public void TestEnd()
	{
		String str = "abc";
		if(str.endsWith("bc"))
		{
			System.out.println(true);
		}
	}
	public String ChopICharactersOffTheEndOfAString(String s, int i, String EOL)
	{
		System.out.println("**********" + EOL);
		if(0 == i || null == s || null == EOL)
		{
			return s;
		}
		int length = s.length();
		if(EOL.length() == 2 && s.endsWith(EOL))
		{
			length -= 2;
			i -= 1;
		}
		if(i > 0)
		{
			length -= i;
		}
		if(length < 0)
		{
			length = 0;
		}
		return s.substring(0, length);
	}
	public String chop(String s, int i)
	{
		return ChopICharactersOffTheEndOfAString(s, i, EOL);
	}
	
	public String chomp(String str, String separator)
	{
		//Removes separator from the end of str if it's there, otherwise leave it alone.
		if(isEmpty(str) || null == separator)
		{
			return str;
		}
		if(str.endsWith(separator))
		{
			return str.substring(0, str.length() - separator.length());
		}
		return str;
	}
	public boolean isEmpty(String str)

	{
		return str.length() == 0 || null == str;
	}
	public final char LF = '\n';
	public final char CR='\r';
	
	public String chop(String str)
	{
		if(null == str)
		{
			return null;
			
		}
		int strLen = str.length();
		if(strLen < 2)
		{
			return "";
		}
		int lastIdx = strLen -1;
		String ret = str.substring(0, lastIdx);
		char last = str.charAt(lastIdx);
		if(last == LF)
		{
			if(ret.charAt(lastIdx - 1) == CR)
			{
				return ret.substring(0, lastIdx - 1);
			}
		}
		return ret;
	}
}
