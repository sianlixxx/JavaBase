package com.rose.logformatter;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LogHTMLFormatter
{

	/**
	 * @param args
	 * @throws IOException
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws SecurityException,
			IOException
	{
		// logHTMLformatter();
		// loggerwithXMLFormatterandFileHandler();
		xMLFormatterbasedLogging();

	}

	private static void xMLFormatterbasedLogging() throws IOException
	{
		XMLFormatter formatter = new XMLFormatter();
		LogRecord record = new LogRecord(Level.INFO, "XML message");
		FileHandler handler = new FileHandler("newxml.xml");
		handler.setFormatter(formatter);
		handler.publish(record);
		handler.flush();
	}

	private static void loggerwithXMLFormatterandFileHandler()
			throws IOException
	{
		Logger logger = Logger.getLogger("my.log");
		Handler handler = null;
		handler = new FileHandler("messages.log");
		logger.addHandler(handler);
		handler.setFormatter(new XMLFormatter());
		logger.info("Our first logging message");
		logger.severe("Something terrible happened");
	}

	private static void logHTMLformatter() throws IOException
	{
		LogManager lm = LogManager.getLogManager();
		Logger parentLogger, childLogger;
		FileHandler xml_handler = new FileHandler("log_output.xml");
		FileHandler html_handler = new FileHandler("log_output.html");
		parentLogger = Logger.getLogger("ParentLogger");
		childLogger = Logger.getLogger("ParentLogger.ChildLogger");
		lm.addLogger(parentLogger);
		lm.addLogger(childLogger);
		parentLogger.setLevel(Level.WARNING);
		childLogger.setLevel(Level.ALL);
		xml_handler.setFormatter(new XMLFormatter());
		html_handler.setFormatter(new HTMLFormatter());
		parentLogger.addHandler(xml_handler);
		childLogger.addHandler(html_handler);
		childLogger.log(Level.FINE, "This is a fine log message");
		childLogger.log(Level.SEVERE, "This is a servere log message");
		xml_handler.close();
		html_handler.close();
	}

}

class HTMLFormatter extends Formatter
{

	@Override
	public String format(LogRecord record)
	{
		String str = "<tr><td>" + (new Date(record.getMillis())).toString()
				+ "</td><td>" + record.getMessage() + "</td></tr>";
		return str;
	}

	public String getHead(Handler h)
	{
		return ("<html>\n  <body>\n"
				+ "<Table border>\n<tr><td>Time</td><td>Log Message</td></tr>\n");
	}

	public String getTail(Handler h)
	{
		return ("</table>\n</body>\n</html>");
	}

}
