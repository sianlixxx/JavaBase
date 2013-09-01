package com.rose.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Damemon extends Thread
{
	private static final int SIZE = 10;
	private Thread[] t = new Thread[SIZE];
	public Damemon()
	{
		setDaemon(true);
		start();
	}
	
	public void run()
	{
		for(int i = 0; i < SIZE; i++)
		{
			t[i] = new DaemonSpawn(i);
			
		}
		for(int i = 0; i < SIZE; i++)
		{
			System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() );
		}
		while(true)
		{
			yield();
		}
	}
}
class DaemonSpawn extends Thread
{
	public DaemonSpawn(int i)
	{
		System.out.println("DaemonSpqwn" + i + "started");
		start();
	}
	public void run()
	{
		while(true)
		{
			yield();
		}
	}
}
public class Daemons extends Thread
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		Thread d = new Damemon();
		System.out.println("d.isDaemon()"  + d.isDaemon());
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Waiting for CR");
		try
		{
			stdin.readLine();
			//sleep(10);
			
		}catch(IOException e)
		{
			e.printStackTrace();
		} /*catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}

