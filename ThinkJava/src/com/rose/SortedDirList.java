package com.rose;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class SortedDirList
{
	private File path;
	private String[] list;
	public SortedDirList(final String afn)
	{
		path = new File(".");
		if(null == afn)
		{
			list = path.list(); 
		}
		else
		{
			list = path.list(new FilenameFilter()
			{
				
				@Override
				public boolean accept(File dir, String name)
				{
					String f = new File(name).getName();
					return f.indexOf(afn) != -1;
				}
			});
			
		}
		sort();
	}
	void print()
	{
		for(int i = 0; i < list.length; i++)
		{
			System.out.println(list[i]);
		}
	}
	private void sort()
	{
		Arrays.sort(list);
	}
	
	public static void main(String[] args)
	{
		SortedDirList sd;
		if(0 == args.length)
		{
			sd = new SortedDirList(null);
		}
		else 
		{
			sd = new SortedDirList(args[0]);
		}
		sd.print();
	}
}
