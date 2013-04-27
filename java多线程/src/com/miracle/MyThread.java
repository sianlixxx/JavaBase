package com.miracle;

public class MyThread extends Thread
{

	private int ticket = 10;
	private String name;
	public MyThread(String name)
	{ 
		this.name = name;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		MyThread mt1 = new MyThread("1号");
		MyThread mt2 = new MyThread("2号");
		MyThread mt3 = new MyThread("3号");
		mt1.start();
		mt2.start();
		mt3.start();

	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			if(this.ticket > 0)
			{
				System.out.println(this.name + "卖票" + (--this.ticket));
			}
			
		}
	}
	

}
