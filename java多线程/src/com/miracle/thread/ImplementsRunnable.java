package com.miracle.thread;

public class ImplementsRunnable implements Runnable
{
	private int ticket = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ImplementsRunnable mt = new ImplementsRunnable();
		new Thread(mt, "1号").start();
		new Thread(mt, "2号").start();
		new Thread(mt, "3号").start();
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			if (this.ticket > 0)
			{
				System.out.println(Thread.currentThread().getName() + "卖票"
						+ (--this.ticket));
			}
		}
	}
}
