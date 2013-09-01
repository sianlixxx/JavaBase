package com.rose.loghandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.SocketHandler;
import java.util.logging.StreamHandler;
import java.util.logging.XMLFormatter;

import org.xml.sax.helpers.XMLFilterImpl;

public class TestHandler
{

	private static Logger logger = Logger.getLogger("MultipleHandlers");

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		//colHandler();
		//TestFileHandler();
		//StreamHandle();
		//testMemHandl();
		SocketHandler handler = new SocketHandler("127.0.0.1", 8080);
		logger.addHandler(handler);
		logger.warning("SocketHandler is working");
	}

	private static void testMemHandl()
	{
		ConsoleHandler handler = new ConsoleHandler();
		MemoryHandler mHandler = new MemoryHandler(handler, 10, Level.ALL);
		logger.addHandler(mHandler);
		logger.setUseParentHandlers(false);
		LogRecord record1 = new LogRecord(Level.SEVERE, "this is Servel level message");
		logger.log(record1);
	}

	private static void StreamHandle()
	{
		OutputStream outStream = System.out;
		StreamHandler handler = new StreamHandler(outStream, new SimpleFormatter());
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);
		logger.info("StreamHandle is working ...");
	}

	private static void TestFileHandler() throws IOException
	{
		LogManager lm = LogManager.getLogManager();
		FileHandler fh = new FileHandler("logging");
		lm.addLogger(logger);
		fh.setFormatter(new XMLFormatter());
		logger.addHandler(fh);
		logger.log(Level.INFO, "test 1");
		logger.log(Level.INFO, "test 2");
		fh.close();
	}

	private static void colHandler() throws IOException
	{
		FileHandler logFile = new FileHandler("MultipleHandlers.xml");
		logger.addHandler(logFile);
		logger.addHandler(new ConsoleHandler());
		logger.warning("Output to multipe handlers");
	}

}
