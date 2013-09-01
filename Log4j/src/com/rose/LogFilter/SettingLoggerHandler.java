package com.rose.LogFilter;

import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SettingLoggerHandler
{
	
	public static void main(String[] args)
	{
		ConsoleHandler handle = new ConsoleHandler();
		handle.setFilter(new Filter()
		{
			
			@Override
			public boolean isLoggable(LogRecord record)
			{
				// TODO Auto-generated method stub
				//return false;
				return true;
			}
		});
		Logger logger = Logger.getLogger("com.mycompany");
		logger.addHandler(handle);
	}
}
