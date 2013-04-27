package com.rose.one;

public class Thread2 implements Runnable
{
	public static void main()
	{
		for (int i = 0; i < 5; i++)
		{
			Runnable r = new Thread2();
			new Thread(r, "thread" + i).start();
		}
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
