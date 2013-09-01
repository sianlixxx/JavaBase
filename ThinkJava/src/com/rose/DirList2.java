package com.rose;

import java.io.File;
import java.io.FilenameFilter;

public class DirList2
{
	public static FilenameFilter filter(final String afn)
	{
		
		//filter中自变量必须是final对于需要匿名内部类；
		return new FilenameFilter()
		{
			private String fn = afn;
			@Override
			public boolean accept(File dir, String name)
			{
				
				String f = new File(name).getName();
				return f.indexOf(fn) != -1;
			}
		};
	}
	public static void main(String[] args)
	{
		try
		{
			File path  = new File(".");
			String[] list;
			if(0 == args.length)
			{
				list = path.list();
			}
			else
			{
				list = path.list(filter(args[0]));
			}
			for(int i = 0; i < list.length; i++)
			{
				System.out.println(list[i]);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
