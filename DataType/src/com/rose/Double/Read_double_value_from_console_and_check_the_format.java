package com.rose.Double;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read_double_value_from_console_and_check_the_format
{
	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		while(true)
		{
			System.out.println("radius?");
			String str = br.readLine();
			double radius;
			try
			{
				radius = Double.valueOf(str).doubleValue();
			} catch (NumberFormatException e)
			{
				System.out.println("Incorrect format");
				continue;
			}
			if(radius <= 0)
			{
				System.out.println("Radius must be positive!");
				continue;
			}
			System.out.println("radius" + radius);
			return ;
		}
	}
}
