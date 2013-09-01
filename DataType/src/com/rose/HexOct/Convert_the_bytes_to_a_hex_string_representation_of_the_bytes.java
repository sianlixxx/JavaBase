package com.rose.HexOct;

import java.text.DecimalFormat;

public class Convert_the_bytes_to_a_hex_string_representation_of_the_bytes
{
	final public static char COMMA = ',';
	final public static String COMMA_STR = ",";
	final public static char ESCAPE_CHAR = '\\';
	private static DecimalFormat oneDecimal = new DecimalFormat("0.0");

	public static String byteToHexString(byte bytes[])
	{
		StringBuffer retString = new StringBuffer();
		for (int i = 0; i < bytes.length; ++i)
		{
			retString.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF))
					.substring(1));
		}
		return retString.toString();
	}
}
