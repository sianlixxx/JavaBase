package com.rose.one;

public class SleepTest
{
	public static void main(String[] arg)
	{
		String[] args = { "one", "two", "three", "for" };
		long start = System.nanoTime();
		for (int i = 0; i < args.length; i++)
		{
			try
			{
				System.out.print(args[i]);
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				// TODO: handle exception
			}
			
		}
		long end = System.nanoTime();
		System.out.println("total time :" + (end - start) / 1000000);
	}
}
