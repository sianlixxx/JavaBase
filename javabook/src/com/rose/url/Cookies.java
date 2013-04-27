package com.rose.url;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Cookies
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, IOException
	{
		CookieManager cm = new CookieManager();
		cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		CookieHandler.setDefault(cm);
		new URL("http://www.google.com.hk").openConnection().getContent();
		List<HttpCookie> cookies = cm.getCookieStore().getCookies();
		for(HttpCookie cookie: cookies)
		{
			System.out.println("Name = " + cookie.getName());
			System.out.println("value = " + cookie.getValue());
			System.out.println("Lifetime(seconds)" + cookie.getMaxAge());
			System.out.println("Path = " + cookie.getPath());
			System.out.println();
		}

	}

}
