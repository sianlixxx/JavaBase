package com.rose.HexOct;

public class Decode_byte_array
{
	static private final int BASELENGTH = 255;
	static private final int LOOKUPLENGTH = 16;
	static private byte[] hexNumberTable = new byte[BASELENGTH];
	static private byte[] lookUpHexAlphabet = new byte[LOOKUPLENGTH];

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
			lookUpHexAlphabet[i] = (byte) ('0' + i);
		for (int i = 10; i <= 15; i++)
			lookUpHexAlphabet[i] = (byte) ('A' + i - 10);
	}

	static public byte[] decode(byte[] binaryData)
	{
		if (binaryData == null)
			return null;
		int lengthData = binaryData.length;
		if (lengthData % 2 != 0)
			return null;

		int lengthDecode = lengthData / 2;
		byte[] decodedData = new byte[lengthDecode];
		for (int i = 0; i < lengthDecode; i++)
		{
			if (!isHex(binaryData[i * 2]) || !isHex(binaryData[i * 2 + 1]))
			{
				return null;
			}
			decodedData[i] = (byte) ((hexNumberTable[binaryData[i * 2]] << 4) | hexNumberTable[binaryData[i * 2 + 1]]);
		}
		return decodedData;
	}

	/**
	 * byte to be tested if it is Base64 alphabet
	 * 
	 * @param octect
	 * @return
	 */
	static boolean isHex(byte octect)
	{
		return (hexNumberTable[octect] != -1);
	}
}
