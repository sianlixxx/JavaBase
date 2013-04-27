package com.rose;

public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Count count = new Count();
		count.count(3, 4);
		System.out.println(count.getResult()+1);

	}

}
