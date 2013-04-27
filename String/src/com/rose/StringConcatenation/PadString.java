package com.rose.StringConcatenation;

import java.util.Arrays;

public class PadString
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public static String prepad(String s, int length)
	{
		return prepad(s, length, ' ');
	}

	public static String prepad(String s, int length, char c)
	{
		StringBuffer sb = new StringBuffer(length);
		sb.append(pad(s, length, c));
		sb.append(s);
		return sb.toString();
	}

	private static String pad(String s, int length, char c)
	{
		int need = length - s.length();
		char[] padding = new char[need];
		Arrays.fill(padding, c);
		return padding.toString();
	}

	public static String postpad(String s, int length, char c)
	{
		StringBuffer sb = new StringBuffer(length);
		sb.append(s);
		sb.append(pad(s, length, c));
		return sb.toString();
	}

	public static String postpad(String s, int length)
	{
		return postpad(s, length);
	}

}
