package com.rose.url;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSockets
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			int port = 555;
			ServerSocket ss = new ServerSocket(port);
			while(true)
			{
				Socket s = ss.accept();
				OutputStream os = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeInt(100);
				s.close();
				ss.close();
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception" + e);
		}
	}

}
