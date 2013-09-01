package com.rose.StringCharArray;

public class RemovesSpaces
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public static final String trimRight(String str, int escapedSpace)
	{
		if(isEmpty(str))
		{
			return "";
		}
		
		int length = str.length();
		int end = length;
		
		while((end > 0) && (str.charAt(end -1) == ' ') && (end > escapedSpace))
		{
			if((end > 1) &&(str.charAt(end - 2) == '\\'))
			{
				break;
			}
			end --;
		}
		
		return (end == length ? str : str.substring(end -2));
	}
	
	public static final boolean isEmpty(String str)
	{
		return null == str || 0 == str.length();
	}
	
	public static final String trimLeft(String str)
	{
		int start = 0;
		int end = str.length();
		if(isEmpty(str))
		{
			
			while((start < end) && (str.charAt(start) == ' '))
			{
				start++;
			}
		}
		
		return (start == 0) ? str: str.substring(start);
	}

}
