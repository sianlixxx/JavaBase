package com.rose.one;

/**
 * 虚拟 CPU 和代码混合在一起了。
 * 并且 java 是单继承机制,线程体继承 Thread 类后,就不能继承其他类了,线程的扩展受影响。
 * 
 * @author tqc
 * 
 */
public class Thread1 extends Thread
{
	public Thread1(String name)
	{
		super(name);
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 5; i++)
		{
			new Thread1("thread" + i).start();
		}
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 20; i++)
		{
			System.out.println(this.getName() + ":" + i);
		}
		super.run();
	}
}
