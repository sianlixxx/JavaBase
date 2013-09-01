package com.rose.Byte;

import java.util.Arrays;


/*
 * 这是byte转换的类
 */
public class Convert
{
	/*
	 * 将单个byte转换为字符串
	 * @Parame
	 */
	
	public static String convertByteToString(byte b)
	{
		return new String(new byte[]
		{ b });
	}

	public static byte convertStringToByte(String str)
	{
		return Byte.valueOf(str);
	}

	public static String arrayEquals(byte[] a1, byte[] a2)
	{
		if (Arrays.equals(a1, a2))
			return "ok";
		else
			return "error";
	}

	public static String ArrayToHexString(byte[] b)
	{
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++)
		{
			int v = b[i] & 0xff;
			if (v < 16)
			{
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	public static byte[] hexStringToByteArray(String s)
	{
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++)
		{
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}
}
