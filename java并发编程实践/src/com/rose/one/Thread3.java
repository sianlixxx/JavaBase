package com.rose.one;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread3
{
	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService exec = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 100; i++)
		{
			Runnable run = new Runner(i);
			exec.execute(run);
		}
		exec.shutdown();
	}
}

class Runner implements Runnable
{
	int index = 0;

	@Override
	public void run()
	{
		long time = (long) (Math.random() * 1000);
		System.out.println(Thread.currentThread().getName() + "  " + index
				+ ":Sleep" + time + "ms");
		try
		{
			Thread.sleep(time);
		}
		catch (InterruptedException e)
		{
			// TODO: handle exception
		}
	}

	public Runner(int index)
	{
		this.index = index;
	}
}
