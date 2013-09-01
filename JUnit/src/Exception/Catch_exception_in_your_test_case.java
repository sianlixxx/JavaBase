package Exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class Catch_exception_in_your_test_case
{

	@Test
	public void testEmpty()
	{
		try
		{
			Largest.largest(new int[]{});
			fail("should have throw an exception");
		}
		catch(RuntimeException e)
		{
			assertTrue(true);
		}
	}
}
class Largest
{
	public static int largest(int[] list)
	{
		int index, max = Integer.MIN_VALUE;
		for (index = 0; index < list.length; index++)
		{
			if (list[index] > max)
			{
				max = list[index];

			}
		}
		return max;
	}
}