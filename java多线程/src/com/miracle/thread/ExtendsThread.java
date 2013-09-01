package com.miracle.thread;

public class ExtendsThread extends Thread
{

	private int ticket = 10;
	private String name;
	public ExtendsThread(String name)
	{ 
		this.name = name;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ExtendsThread mt1 = new ExtendsThread("1号");
		ExtendsThread mt2 = new ExtendsThread("2号");
		ExtendsThread mt3 = new ExtendsThread("3号");
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
