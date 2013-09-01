package com.rose.NumberFormat;

import java.text.NumberFormat;

public abstract class Get_Percent_Value
{
	public static String replaceAll(String original, String replace, String with)
	{
		if (null == original)
		{
			return original;
		}
		final int len = replace.length();
		StringBuffer sb = new StringBuffer(original.length());
		int start = 0;
		int found = -1;

		while ((found = original.indexOf(replace, start)) != -1)
		{
			sb.append(original.substring(start, found));
			sb.append(with);
		}
		sb.append(original.substring(start));
		return sb.toString();
	}

	public static String getPercentValue(double value)
	{
		value = Math.floor((value) * 100) / 100; // to represent 199 covered
													// lines from 200 as 99%
													// covered, not 100 %
		return NumberFormat.getPercentInstance().format(value);
	}
}
