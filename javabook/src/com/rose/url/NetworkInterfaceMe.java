package com.rose.url;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkInterfaceMe
{

	/**
	 * @param args
	 * @throws UnknownHostException 
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws UnknownHostException, SocketException
	{
		// TODO Auto-generated method stub
		InetAddress ia = InetAddress.getByName("www.google.hk");
		System.out.println(ia);
		NetworkInterface ni = NetworkInterface.getByInetAddress(ia);
		System.out.println(ni);
				
				
	}

}
