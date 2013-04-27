package com.rose;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

@SuppressWarnings("serial")
public class BeanUtil
{
	public static <T> T cloneTo(T src) throws RuntimeException, FileNotFoundException
	{
		/*FileOutputStream fs = new FileOutputStream("foo.ser"); 
		FileInputStream is = new FileInputStream("foo.ser");*/
		ByteArrayOutputStream memoryBuffer = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		T dist = null;
		try
		{
			out = new ObjectOutputStream(memoryBuffer);
			out.writeObject(src);
			out.flush();
			in = new ObjectInputStream(new ByteArrayInputStream( memoryBuffer.toByteArray()));
			//in = new ObjectInputStream(is);
			
			dist = (T) in.readObject();
		} catch (Exception e)
		{
			System.out.println("fail");
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally
		{
			if (out != null)
				try
				{
					out.close();
					out = null;
				} catch (IOException e)
				{
					throw new RuntimeException(e);
				}
			if (in != null)
				try
				{
					in.close();
					in = null;
				} catch (IOException e)
				{
					throw new RuntimeException(e);
				}
		}
		return dist;
	}

	public static void main(String[] args) throws FileNotFoundException, RuntimeException
	{
		Administrator src = new Administrator(new User("Kent", "123456",
				new Date()), true);
		Administrator dist = BeanUtil.cloneTo(src);
		System.out.println(src == dist); // false
		System.out.println(src.equals(dist)); // true
		System.out.println(src.getUser() == dist.getUser()); // false ! Well
																// done!
		System.out.println(src.getUser().equals(dist.getUser())); // true
	}

}
