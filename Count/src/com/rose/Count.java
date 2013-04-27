package com.rose;

import java.util.ArrayList;
import java.util.List;

public class Count
{
	private int Result;
	public void count(int total, int number)
	{
		List<Integer> list = new ArrayList<Integer>(total);
		for(int i = 0; i < total; i++)
		{
			list.add(i);
		}
		int begin = -1;
		//System.out.println("³öÁÐË³Ðò£º\r\n");
		while(total > 0)
		{
			begin += number;
			//System.out.println( list.remove(begin%total));
			Result = list.remove(begin%total);
			begin = (begin %total) - 1;
			total--;
		}
		
	}
	public int getResult()
	{
		return Result;
	}
}
