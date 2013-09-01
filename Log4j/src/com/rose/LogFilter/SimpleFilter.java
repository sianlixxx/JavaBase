package com.rose.LogFilter;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SimpleFilter
{
	private static Logger logger = Logger.getLogger("simpleFilter");
	static class A
	{
		
	};
	static class B
	{
		
	};
	static void sendLogMessage()
	{
		logger.log(Level.WARNING, "message 1", new A());
		logger.log(Level.WARNING, "message 2", new B());
	}
	public static void main(String[] args)
	{
		sendLogMessage();
		logger.setFilter(new Filter()
		{
			
			@Override
			public boolean isLoggable(LogRecord record)
			{
				Object[] params = record.getParameters();
				if(null == params)
				{
					return true;
				
				}
				if(params[0] instanceof A)
				{
					return true;
				}
				return false;
			}
		});
		logger.info("After setting filter...");
		sendLogMessage();
	}
}
