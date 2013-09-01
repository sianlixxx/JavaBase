package com.rose.url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLDecoder
{

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException
	{
		Decoder();
		System.out.println();
		Encoding();
		
		String uid = new java.rmi.server.UID().toString(); // guaranteed unique
	    String s = URLEncoder.encode(uid,"UTF-8"); // encode any special chars
	    System.out.println(s);//455251f6%3A1392632d968%3A-8000

	}
	public static void Decoder() throws UnsupportedEncodingException
	{
		String line = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode("value", "UTF-8");
		String[] pairs = line.split("\\&");
		for(int i = 0; i < pairs.length; i++)
		{
			String[] fields = pairs[i].split("=");
			String name = java.net.URLDecoder.decode(fields[0], "UTF-8");
			System.out.println(name);
			String value = java.net.URLDecoder.decode(fields[1], "UTF-8");
			System.out.print(value);
		}
		
	}
	public static void Encoding() throws UnsupportedEncodingException
	{
		String encodedData = URLEncoder.encode("The string ", "UTF-8");
	    System.out.println(encodedData);
	    System.out.println(java.net.URLDecoder.decode(encodedData, "UTF-8"));
	}

}
