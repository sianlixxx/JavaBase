package com.rose.logformatter;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log1
{
	private static Logger logger = Logger.getLogger("LogToFile2");

	/**
	 * @param args
	 * @throws IOException
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws SecurityException,
			IOException
	{
		// SetLogFormatter();

		// Createcustomformatter();
		
		Handler conHdl = new ConsoleHandler();
		conHdl.setFormatter(new CustomFormater());
		logger.addHandler(conHdl);
		logMessage();
	
			

	}

	static class  CustomFormater extends Formatter
	{

		@Override
		public synchronized String format(LogRecord record)
		{
			String methodName = record.getSourceMethodName();
			String message = record.getMessage();
			StringBuffer buffer = new StringBuffer(50);
			buffer.append(methodName);
			buffer.append("=");
			buffer.append(message);
			return buffer.toString();
		}

	}

	private static void Createcustomformatter()
	{
		logger.setUseParentHandlers(false);
		Handler conHdlr = new ConsoleHandler();
		conHdlr.setFormatter(new Formatter()
		{

			@Override
			public String format(LogRecord record)
			{
				return record.getLevel() + " :" + record.getSourceClassName()
						+ "-:-" + record.getSourceMethodName() + "-:-"
						+ record.getMessage() + "\n";
			}
		});
		logger.addHandler(conHdlr);
		logMessage();
	}

	private static void logMessage()
	{
		logger.info("Line One");
		logger.info("Line Two");
	}

	private static void SetLogFormatter() throws IOException
	{
		FileHandler logFile = new FileHandler("LogToFile2.txt");
		logFile.setFormatter(new SimpleFormatter());
		logger.addHandler(logFile);
		logger.info("A message logged to the file");
	}

}
