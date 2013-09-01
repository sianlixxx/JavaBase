package com.rose.StringReplace;

import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;

public class StringReplace
{
	public static void main(String[] args)
	{
		String tmp;
		StringReplace SR = new StringReplace();
		SR.replace();
		tmp = SR.ReplacingSubstringsInAString("abcd", "bc", "dd");
		System.out.println(tmp);
		System.out.println("\r\n|\r|\n|\n\r".replaceAll("(\r\n|\r|\n|\n\r)",
				"<br>"));
		System.out.println(">" + "  as  bb ss".replaceAll("\\b\\s{2,}\\b", " ")
				+ "<");
		System.out.println(formatString("é"));
		System.out.println("ab1 2c9_8z yx7".replaceAll("\\D", ""));
		System.out.println(RemoveWhitePlace("  a  b  c d "));
		System.out
				.println(removeCharsFromString("abcdefg", "ab".toCharArray()));
		System.out.println(collapseSpace("baaa  bb  ccdc"));

	}

	public void replace()
	{
		String str = "a b c d e f g";
		System.out.println(str.replace(' ', '|'));
		;
	}

	public String ReplacingSubstringsInAString(String str, String pattern,
			String replace)
	{
		int start = 0;
		int index = 0;
		StringBuffer result = new StringBuffer();
		while ((index = str.indexOf(pattern, start)) >= 0)
		{
			result.append(str.substring(start, index));
			result.append(replace);
			start = index + pattern.length();
		}
		result.append(str.substring(start));
		return result.toString();
	}

	public static String formatString(String s)
	{
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		return temp.replaceAll("[^\\p{ASCII}]", "");
	}

	public static String RemoveWhitePlace(String str)
	{
		// Returns a new string with all the whitespace removed
		StringBuffer retn = new StringBuffer();
		if (str != null)
		{
			int len = str.length();
			for (int i = 0; i < len; i++)
			{
				if (!Character.isWhitespace(str.charAt(i)))
				{
					retn.append(str.charAt(i));
				}
			}
		}
		return retn.toString();
	}

	public static String removeCharsFromString(String str, char[] unWantChar)
	{
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < unWantChar.length; i++)
		{
			set.add(Character.valueOf(unWantChar[i]));
		}
		StringBuffer sb = new StringBuffer(str.length());
		for (int i = 0; i < str.length(); i++)
		{
			if (!set.contains(str.charAt(i)))
			{
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();

	}
	public static String collapseSpace(String str)
	{
		//Remove/collapse multiple spaces
		StringBuffer sb = new StringBuffer();
		char last = str.charAt(0);
		char cur ;
		for(int i = 0; i < str.length(); i++)
		{
			cur = str.charAt(i);
			if(cur != ' ' || last != ' ')
			{
				sb.append(cur);
				last = cur;
			}
		}
		return sb.toString();
	}

}
