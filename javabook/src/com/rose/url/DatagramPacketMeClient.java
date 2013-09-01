package com.rose.url;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class DatagramPacketMeClient
{

	/**
	 * @param args
	 */
	private final static int PORT = 10000;
	final static String ADDR2 = "localhost";

	public static void main(String[] args) throws IOException
	{
		//Sigle();
		Muilt();
	}

	private static void Sigle()
	{
		System.out.println("client is starting");
		try (DatagramSocket dgs = new DatagramSocket())
		{
			byte[] buffer;
			buffer = "Send me a datagram".getBytes();
			InetAddress ia = InetAddress.getByName(ADDR2);
			DatagramPacket dgp = new DatagramPacket(buffer, buffer.length, ia,
					PORT);
			dgs.send(dgp);
			byte[] buffer2 = new byte[100];
			dgp = new DatagramPacket(buffer2, buffer.length, ia, PORT);
			dgs.receive(dgp);
			System.out.println(new String(dgp.getData()));
		} catch (IOException ioe)
		{
			System.err.println("I/O error: " + ioe.getMessage());
		}
	}

	public static void Muilt() throws IOException
	{
		try (MulticastSocket mcs = new MulticastSocket(PORT))
		{
			InetAddress group = InetAddress.getByName("224.0.0.0");
			mcs.joinGroup(group);
			for (int i = 0; i < 10; i++)
			{
				byte[] buffer = new byte[256];
				DatagramPacket dgp = new DatagramPacket(buffer, buffer.length);
				mcs.receive(dgp);
				byte[] buffer2 = new byte[dgp.getLength()];
				System.arraycopy(dgp.getData(), 0, buffer2, 0, dgp.getLength());
				System.out.println(new String(buffer2));
			}

		} catch (IOException ioe)
		{
			System.err.println("I/O error" + ioe.getMessage());
		}
	}

}
