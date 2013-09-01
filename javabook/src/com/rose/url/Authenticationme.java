package com.rose.url;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Authenticationme
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		Authenticator.setDefault(new BasicAuthenticator());
		
		//String s = "http://test.webdav.org/auth-basic/";
		String s = "http://www.tmall.com";
		
		URL url = new URL(s);
		URLConnection urlc = url.openConnection();
		Map<String, List<String>> hf = urlc.getHeaderFields();
		for (String key : hf.keySet())
			System.out.println(key + ": " + urlc.getHeaderField(key));
		System.out.println(((HttpURLConnection) urlc).getResponseCode());
	}
	static class  BasicAuthenticator extends Authenticator {
		  final static String USERNAME = "user1";
		  final static String PASSWORD = "user1";

		  @Override
		  public PasswordAuthentication getPasswordAuthentication() {
		    System.out.println("Password requested " + getRequestingHost()
		        + " for scheme " + getRequestingScheme());
		    return new PasswordAuthentication(USERNAME, PASSWORD.toCharArray());
		  }

	}
}
