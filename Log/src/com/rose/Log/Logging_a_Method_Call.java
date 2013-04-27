package com.rose.Log;

import java.io.IOError;
import java.io.IOException;
import java.net.NetPermission;
import java.util.logging.Level;
import java.util.logging.Logger;

class Logging_a_Method_Call
{
	public boolean myMethod(int p1, Object p2)
	{
		Logger logger = Logger.getLogger("com.rose.Log.Logging_a_Method_Call");

		if (logger.isLoggable(Level.FINER))
		{
			logger.entering(this.getClass().getName(), "myMethod", new Object[]
			{ new Integer(p1), p2 });
		}
		System.out.println("Method body");
		boolean result = true;
		if (logger.isLoggable(Level.FINER))
		{
			logger.exiting(this.getClass().getName(), "myMethod", new Boolean(
					result));
			logger.exiting(this.getClass().getName(), "myMethod");
		}
		return result;
	}

	public static void main(String[] args)
	{
		// new Logging_a_Method_Call().myMethod(1, 2);
		Logger logger = Logger.getLogger("com.rose.Log.Logging_a_Method_Call");
		try
		{
			//throw new IOException();
		} catch (Exception e)
		{
			logger.log(Level.SEVERE, "Uncaught exception");
		}
		Exception ex = new IllegalStateException();
		logger.throwing("Logging class", "my Method", ex);
		logger.info("Logging an INFO-level message");
	}
}
