package com.rose.HexOct;

public class Converting_hexadecimal_strings
{
	private static final char[] DIGITS = 
        {'0', '1', '2', '3', '4', '5', '6', '7',
         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	public static final String toHex(byte[] data)
	{
		final StringBuffer sb = new StringBuffer(data.length);
		for(int i = 0; i < data.length; i++)
		{
			sb.append(DIGITS[(data[i] >>> 4) & 0x0f]);
			sb.append(DIGITS[data[i] & 0x0f]);
		}
		return sb.toString();
	}
}
