package com.rose.StringByteArray;

public class Convertbytestoabase16string
{
	private final static char[] HEX = new char[]
	{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F' };
	 private static char[] hex_table = {
		    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		    'a', 'b', 'c', 'd', 'e', 'f'
		};

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		for(byte bt: toHexByte("abc", 1, 3))
		{
			System.out.println(bt);
		}

	}

	public static String encode(byte[] byteArray)
	{
		StringBuffer hexBuffer = new StringBuffer(byteArray.length);
		for (int i = 0; i < byteArray.length; i++)
		{
			for (int j = 1; j >= 0; j--)
			{
				hexBuffer.append(HEX[(byteArray[i] >> (j * 4)) & 0xF]);
			}
		}
		return hexBuffer.toString();
	}

	public static byte[] decode(String s)
	{
		int len = s.length();
		byte[] r = new byte[len >> 1];
		for (int i = 0; i < r.length; i++)
		{
			int digit1 = s.charAt(i * 2), digit2 = s.charAt(i * 2 + 1);
			if (digit1 >= '0' && digit1 <= '9')
			{
				digit1 -= '0';
			} else if (digit1 >= 'A' && digit1 <= 'F')
			{
				digit1 -= 'A' - 10;
			}

			if (digit2 >= '0' && digit2 <= '9')
			{

				digit2 -= '0';
			} else if (digit2 >= 'A' && digit2 <= 'F')
			{
				digit2 -= 'A' - 10;
			}
			r[i] = (byte) ((digit1 << 4) + digit2);
		}
		return r;
	}
	/**
	 * Convert a string into a byte array in hex format.
	 * @param str
	 * @param offset
	 * @param length
	 * @return
	 */
	 public static byte[] toHexByte(String str, int offset, int length)
	  {
	      byte[] data = new byte[(length - offset) * 2];
	      int end = length;

	      for (int i = 0; i < end - offset; i += 1)
	      {
	          char ch = str.charAt(i+offset);
	          //System.out.println(i +""+ ch + "" + Integer.valueOf(ch));
	          int high_nibble = (ch & 0xf0) >>> 4;
	          int low_nibble = (ch & 0x0f);
	          data[i*2] = (byte)high_nibble;
	          data[i*2+1] = (byte)low_nibble;
	         // System.out.println(data[i] + "" + data[i + 1]);
	      }
	      return data;
	  }

	 public static byte[] getAsciiBytes(String input)
	  {
	    char[] c = input.toCharArray();
	    byte[] b = new byte[c.length];
	    for (int i = 0; i < c.length; i++)
	      b[i] = (byte)(c[i] & 0x007F);

	    return b;
	  }
}
