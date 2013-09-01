package com.rose.one;


public class JoinTest extends Thread
{
	static int result = 0;
	public JoinTest(String name)
	{
		super(name);
	}
	public static void main(String[] args)
	{
		System.out.println("主线程执行");
		Thread t = new JoinTest("计算线程");
		t.start();
		System.out.println("result:" + result);
		try
		{
			long start = System.nanoTime();
			t.join();
			long end = System.nanoTime();
			System.out.println((end - start) / 1000000 + "毫秒后" + result);
		}
		catch (InterruptedException e)
		{
			// TODO: handle exception
		}
	}
	
	public void run()
	{
		System.out.println(this.getName() + "begin");
		try
		{
			Thread.sleep(4000);
		}
		catch (InterruptedException e)
		{
			// TODO: handle exception
		}
		result = (int)(Math.random() * 1000);
		System.out.println(this.getName() + "end");
	}
}
