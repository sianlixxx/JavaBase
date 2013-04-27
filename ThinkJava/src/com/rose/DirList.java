package com.rose;
import java.io.*;
public class DirList
{
	public static void main(String[] args)
	{
		try
		{
			File path = new File(".");
			String[] list;
			if(0 == args.length)
			{
				list = path.list();
			}
			else
			{
				list = path.list(new DirFilter(args[0]));
			}
			for(int i = 0; i < list.length; i++)
			{
				System.out.println(list[i]);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

class DirFilter implements FilenameFilter 
{
	String afn;
	public DirFilter(String afn)
	{
		super();
		this.afn = afn;
	}

	@Override
	public boolean accept(File dir, String name)
	{
		String f = new File(name).getName();
		return f.indexOf(afn) != -1;
	}
	
}