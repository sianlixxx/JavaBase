package com.rose.Character;

public class Java_identifier
{
	public static boolean isJavaIdentifier(String test)
	{
		if (null == test || test.length() == 0)
		{
			return false;
		}
		if (!Character.isJavaIdentifierPart(test.charAt(0))
				&& test.charAt(0) != ' ')
		{
			return false;
		}
		for (int i = 1; i < test.length(); i++)
		{
			if (!Character.isJavaIdentifierPart(test.charAt(i))
					&& test.charAt(i) != '_')
			{
				return false;
			}
		}
		return true;
	}
}
