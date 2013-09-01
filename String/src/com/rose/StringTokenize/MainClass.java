package com.rose.StringTokenize;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainClass
{
	public static void main(String[] args)
	{
		String text = "a b c d e f ";
		String[] words = text.split("[, .]", 2);
		for (String s : words)
		{
			System.out.println(s);
		}
	}

	public static String[] parseCommaDelimitedList(String csvList)
	{
		String[] result = parseList(csvList, ",");
		for (int i = 0; i < result.length; i++)
		{
			result[i] = result[i].trim();
		}
		return result;
	}

	private static String[] parseList(String csvList, String string)
	{
		List<String> result = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(csvList, string);
		while (tokenizer.hasMoreTokens())
		{
			result.add(tokenizer.nextToken());
		}
		return (String[]) result.toArray(new String[0]);
	}

	public static String[] paseWhitespaceDelimitedList(String wsvList)
	{
		return parseList(wsvList, "\t");
	}
}
