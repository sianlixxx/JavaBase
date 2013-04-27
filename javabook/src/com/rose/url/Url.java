package com.rose.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Url
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		Output("http://google.com");

	}

	/**
	 * Outputting the contents of the resource identified via a URL command-line
	 * argument
	 * 
	 * @throws IOException
	 */
	public static void Output(String str) throws IOException
	{
		URL url = new URL(str);
		try
		{
			InputStream is = url.openStream();
			int ch;
			while ((ch = is.read()) != -1)
			{
				System.out.println((char) ch);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
