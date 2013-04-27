package com.rose.StringByteArray;

public class MainClass
{
	static private final int BASELENGTH = 255;
	static private final int LOOKUPLENGTH = 16;
	static private byte[] hexNumberTable = new byte[BASELENGTH];
	static private byte[] lookUpHexAlphabet = new byte[LOOKUPLENGTH];
	/** lowerCase = 'a' .. 'z', '0'..'9', '-' */
	private static final char[] LOWER_CASE =
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '-',
			0, 0, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 0, 0, 0, 0,
			0, 0, 0, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z', 0, 0, 0, 0, 0, 0, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	static
	{
		for (int i = 0; i < BASELENGTH; i++)
		{
			hexNumberTable[i] = -1;
		}
		for (int i = '9'; i >= '0'; i--)
		{
			hexNumberTable[i] = (byte) (i - '0');
		}
		for (int i = 'F'; i >= 'A'; i--)
		{
			hexNumberTable[i] = (byte) (i - 'A' + 10);
		}
		for (int i = 'f'; i >= 'a'; i--)
		{
			hexNumberTable[i] = (byte) (i - 'a' + 10);
		}
		for (int i = 0; i < 10; i++)
		{
			lookUpHexAlphabet[i] = (byte) (i + '0');

		}
		for (int i = 10; i <= 15; i++)
		{
			lookUpHexAlphabet[i] = (byte) (i + 'A' - 10);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		/**
		 * Obtaining the Characters in a String as an Array of Bytes
		 */
		String str1 = "abcdefg";
		byte[] bt1 = str1.getBytes();
		for (byte bt : bt1)
		{
			System.out.println(bt);
		}

		/**
		 * Construct string from subset of char array.
		 */
		byte[] ascii =
		{ 65, 66, 67, 68, 69, 70 };
		String str2 = new String(ascii);
		System.out.println(str2);
		System.out.println(new String(ascii, 2, 3));
		System.out.println(bytesToString(ascii));

		String str3 = "111213";
		byte[] bt3 = toByteArray(str3);
		for (byte bt : bt3)
		{
			System.out.println(bt);
		}
		
		System.out.println(toHexString(bt3));

	}

	/**
	 * Converts bytes to a hex String
	 * 
	 * @param binaryData
	 * @return
	 */
	static public String bytesToString(byte[] binaryData)
	{
		if (null == binaryData)
		{
			return null;
		}
		return new String(encode(binaryData));
	}

	static public byte[] encode(byte[] binaryData)
	{
		if (null == binaryData)
		{
			return null;
		}

		int lengthData = binaryData.length;
		int lengthEncode = lengthData * 2;
		byte[] encodeData = new byte[lengthEncode];
		for (int i = 0; i < lengthData; i++)
		{
			encodeData[i * 2] = lookUpHexAlphabet[(binaryData[i] >> 4) & 0xf];
			encodeData[i * 2 + 1] = lookUpHexAlphabet[(binaryData[i] & 0xf)];
		}
		return encodeData;

	}

	/**
	 * Get byte array from hex string
	 */
	public static final byte[] toByteArray(String hexString)
	{
		int arrLength = hexString.length() >> 1;
		byte[] buf = new byte[arrLength];
		for (int i = 0; i <= hexString.length() - 2; i += 2)
		{
			String str = hexString.substring(i, i + 2);
			buf[i >> 1] = (byte) Integer.parseInt(str, 16);

		}

		return buf;
	}

	public static final String toHexString(byte[] res)
	{
		StringBuffer sb = new StringBuffer(res.length << 1);
		for (int i = 0; i < res.length; i++)
		{
			String digit = Integer.toHexString(res[i]);
			if (digit.length() == 1)
			{
				digit = '0' + digit;
			}
			sb.append(digit);
		}
		return sb.toString().toUpperCase();
	}
}
