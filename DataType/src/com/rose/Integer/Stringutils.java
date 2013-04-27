package com.rose.Integer;

import java.text.DecimalFormat;

public class Stringutils
{
	public final static char COMMA = ',';
	public final static String COMMA_STR = ",";
	public final static char ESCAPE_CHAR = '\\';
	private static DecimalFormat oneDecimal = new DecimalFormat("0.0");
	
	public static String humanReadableInt(long number)
	{
		long absNumber = Math.abs(number);
		double result = number;
		String suffix = "";
		if(absNumber < 1024)
		{
			
		}
		else if(absNumber < 1024 * 1024)
		{
			result = number / 1024.0;
			suffix = "k";
		}
		else if(absNumber < 1024 * 1024 * 1024)
		{
			result = number / (1024 * 1024);
			suffix = "m";
		}
		else
		{
			result = number / (1024.0 * 1024 * 1024);
			suffix = "g";
		}
		return oneDecimal.format(result) + suffix;
		
	}
	public static void main(String [] args)
	{
		String tem = humanReadableInt(10000);
		System.out.println(tem);
		
		tem = humanReadableInt(1025 * 1025);
		System.out.println(tem);
		tem = humanReadableInt(102);
		System.out.println(tem);
	}
}
