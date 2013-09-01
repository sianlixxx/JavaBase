package com.rose.url;

import java.net.URI;
import java.net.URISyntaxException;

public class Uri
{

	/**
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException
	{
		NewUri("http://www.example.org");
		/*
		 * Normalization is the process of removing unnecessary "." and ".."
		 * path segments from a hierarchical URI's path component.
		 */
		System.out.println(new URI("http://www.baidu.com/./").normalize());
		
		/**
		 * Resolution is the process of resolving one URI against another URI.
		 */
		System.out.println(new URI("http://www.baidu.com").resolve("/index.html"));
		
		/**
		 * Resolution is the process of resolving one URI against another URI.
		 */
		System.out.println(new URI("http://www.baidu.com").relativize(new URI("http://www.baidu.com/index.html")));
	}

	public static void NewUri(String str) throws URISyntaxException
	{
		URI uri = new URI(str);
		System.out.println("URI: " + uri);
		System.out.println("Raw Authority:" + uri.getRawAuthority());
		System.out.println("Raw Fragment:" + uri.getRawFragment());
		System.out.println("Fragment:" + uri.getFragment());
		System.out.println("Authority :" + uri.getAuthority());
		System.out.println("Authority :" + uri.getRawPath());
		System.out.println("RawQuery :" + uri.getRawQuery());
		System.out.println("RawSchemeSpecificPart:"
				+ uri.getRawSchemeSpecificPart());
		System.out.println("RawUserInfo: " + uri.getRawUserInfo());

	}

}
