package com.rose.StringCompare;

public class Mainclass
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		/*String a = "a";
		String A = "A";
		if (a.equalsIgnoreCase(A))
		{
			System.out.println("a == A");
		}
		if (a.compareToIgnoreCase(A) == 0)
		{
			System.out.println("a == A");
		}
		String str1 = "Hello";
		String str2 = new String(str1);
		if (str1 == str2)
		{
			System.out.println("str1 == str2");
		}
		if (str1.equals(str2))
		{
			System.out.println("str1 equals str2");
		}

		String searchMe = "Green eggs and Ham";
		String findMe = "eggs";
		int searchMeLength = searchMe.length();
		int findMeLength = findMe.length();
		boolean foundIt = false;
		for (int i = 0; i <= searchMeLength - findMeLength; i++)
		{
			if (searchMe.regionMatches(i, findMe, 0, findMeLength))
			{
				foundIt = true;
				System.out.println(searchMe.substring(i, i + findMeLength));
				break;
			}
		}
		if (!foundIt)
		{
			System.out.println("No match found");
		}
		System.out.println(defference("abc", "abcccc"));
		*/
		String[] str =
		{"aaa","aaa"};
		System.out.println(getCommonPrefix(str));
	}

	/*
	 * public static String compressQuotes(String source, String quotes) {
	 * String result = source; int index;
	 * 
	 * Find the first occurrence of adjacent quotes. index =
	 * result.indexOf(quotes);
	 * 
	 * 
	 * Replace each occurrence with a single quote and begin the search for the
	 * next occurrence from where we left off.
	 * 
	 * while (index != -1) { result = result.substring(0, index + 1) +
	 * result.substring(index + 2); index = result.indexOf(quotes, index + 1); }
	 * 
	 * return result; }
	 */

	/**
	 * Compares two Strings, and returns the portion where they differ
	 */
	public static int indexOfDifference(String str1, String str2)
	{
		if (str1 == str2)
		{
			return -1;
		}
		if (null == str1 || null == str2)
		{
			return 0;
		}
		int i;
		for (i = 0; i < str1.length() && i < str2.length(); ++i)
		{
			if (str1.charAt(i) != str2.charAt(i))
			{
				break;
			}
		}
		if (i < str1.length() || i < str2.length())
		{
			return i;
		}
		return -1;
	}

	public static String defference(String str1, String str2)
	{
		if (str1 == null)
		{
			return str2;
		}
		if (str2 == null)
		{
			return str1;
		}

		int at = indexOfDifference(str1, str2);
		if (at == -1)
		{
			return "";
		}
		return str2.substring(at);
	}

	public static String getCommonPrefix(String[] strs)
	{
		if (strs == null || strs.length == 0)
		{
			return "";
		}
		int smallestIndexOfDiff = indexOfDifference(strs);
		
		if (smallestIndexOfDiff == -1)
		{
			// all strings were identical
			if (strs[0] == null)
			{
				return "**";
			}
			return strs[0];
		} else if (smallestIndexOfDiff == 0)
		{
			// there were no common initial characters
			return "***";
		} else
		{
			// we found a common initial character sequence
			return strs[0].substring(0, smallestIndexOfDiff);
		}
	}

	public static int indexOfDifference(String[] strs)
	{
		if (strs == null || strs.length <= 1)
		{
			return -1;
		}
		boolean anyStringNull = false;
		boolean allStringsNull = true;
		int arrayLen = strs.length;
		int shortestStrLen = Integer.MAX_VALUE;
		int longestStrLen = 0;

		// find the min and max string lengths; this avoids checking to make
		// sure we are not exceeding the length of the string each time through
		// the bottom loop.
		for (int i = 0; i < arrayLen; i++)
		{
			if (strs[i] == null)
			{
				anyStringNull = true;
				shortestStrLen = 0;
				
			} else
			{
				allStringsNull = false;
				shortestStrLen = Math.min(strs[i].length(), shortestStrLen);
				longestStrLen = Math.max(strs[i].length(), longestStrLen);
			}
		}

		// handle lists containing all nulls or all empty strings
		if (allStringsNull || (longestStrLen == 0 && !anyStringNull))
		{
			return -1;
		}

		// handle lists containing some nulls or some empty strings
		if (shortestStrLen == 0)
		{
			
			return 0;
		}

		// find the position with the first difference across all strings
		int firstDiff = -1;
		for (int stringPos = 0; stringPos < shortestStrLen; stringPos++)
		{
			char comparisonChar = strs[0].charAt(stringPos);
			for (int arrayPos = 1; arrayPos < arrayLen; arrayPos++)
			{
				if (strs[arrayPos].charAt(stringPos) != comparisonChar)
				{
					firstDiff = stringPos;
					break;
				}
			}
			if (firstDiff != -1)
			{
				break;
			}
		}

		if (firstDiff == -1 && shortestStrLen != longestStrLen)
		{
			// we compared all of the characters up to the length of the
			// shortest string and didn't find a match, but the string lengths
			// vary, so return the length of the shortest string.
			return shortestStrLen;
		}
		return firstDiff;
	}
}
