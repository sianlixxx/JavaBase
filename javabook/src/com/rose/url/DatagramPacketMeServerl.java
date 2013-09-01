package com.rose.url;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class DatagramPacketMeServerl
{
	private final static int PORT = 10000;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//sigle();
		Multicast();

	}

	private static void sigle()
	{
		System.out.println("Server is starting");
		try (DatagramSocket dgs = new DatagramSocket(PORT))
		{
			System.out.println("Send buffer size = " + dgs.getSendBufferSize());
			System.out.println("Receive buffer size = "
					+ dgs.getReceiveBufferSize());
			byte[] data = new byte[100];
			DatagramPacket dgp = new DatagramPacket(data, data.length);
			while (true)
			{
				dgs.receive(dgp);
				System.out.println(new String(data));
				dgs.send(dgp);
			}
		} catch (Exception ioe)
		{
			System.err.println("I/O error: " + ioe.getMessage());
		}
	}

	public static void Multicast()
	{
		try(MulticastSocket mcs = new MulticastSocket())
		{
			InetAddress group = InetAddress.getByName("224.0.0.0");
			byte[] dummy = new byte[0];
			DatagramPacket dgp = new DatagramPacket(dummy, 0, group, PORT);
			int i = 0;
			while(true)
			{
				byte[] buffer = ("line" + i).getBytes();
				dgp.setData(buffer);
				dgp.setLength(buffer.length);
				mcs.send(dgp);
				i++;
			}
			
		}catch(IOException ioe)
		{
			System.out.println("I/O error" + ioe.getMessage());
		}
	}
}
