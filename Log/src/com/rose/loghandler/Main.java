package com.rose.loghandler;

import java.util.logging.ConsoleHandler;
import java.util.logging.ErrorManager;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class LogWindow extends JFrame
{
	private JTextArea textArea = new JTextArea();

	public LogWindow()
	{
		super("");
		setSize(300, 300);
		add(new JScrollPane(textArea));
		setVisible(true);
	}

	public void showInfo(String data)
	{
		textArea.append(data);
		this.validate();
	}
}

class WindowHandler extends Handler
{
	private LogWindow window = null;

	private Formatter formatter = null;

	private Level level = null;

	private static WindowHandler handler = null;

	private WindowHandler()
	{
		LogManager manager = LogManager.getLogManager();
		String className = this.getClass().getName();
		String level = manager.getProperty(className + ".level");
		setLevel(level != null ? Level.parse(level) : Level.INFO);
		if (window == null)
			window = new LogWindow();
	}

	public static synchronized WindowHandler getInstance()
	{
		if (handler == null)
		{
			handler = new WindowHandler();
		}
		return handler;
	}

	public synchronized void publish(LogRecord record)
	{
		/*
		 * String message = null; if (!isLoggable(record)) return; message =
		 * getFormatter().format(record); message = "error";
		 * window.showInfo(message);
		 */

		if (!isLoggable(record))
		{
			return;
		}
		String msg;
		try
		{
			Formatter fo = getFormatter();
			msg = fo.format(record);
		} catch (Exception ex)
		{
			// We don't want to throw an exception here, but we
			// report the exception to any registered ErrorManager.
			reportError(null, ex, ErrorManager.FORMAT_FAILURE);
			return;
		}
		window.showInfo(msg);
		
	}

	public void close()
	{
	}

	public void flush()
	{
	}
}

public class Main
{
	private WindowHandler handler = null;

	private Logger logger = null;

	public Main()
	{
		handler = WindowHandler.getInstance();
		logger = Logger.getLogger("logging.handler");
		logger.addHandler(handler);
	}

	public void logMessage()
	{
		logger.info("Hello from ...");
	}

	public static void main(String args[])
	{
		Main demo = new Main();
		demo.logMessage();
		WindowHandler h = WindowHandler.getInstance();
		LogRecord r = new LogRecord(Level.WARNING,
				"The Handler publish method...");
		//h.publish(r);
		ConsoleHandler handler = new ConsoleHandler();
		handler.publish(r);
	}
}