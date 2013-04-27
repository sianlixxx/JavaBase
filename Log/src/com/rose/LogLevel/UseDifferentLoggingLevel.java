package com.rose.LogLevel;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UseDifferentLoggingLevel
{
	private static Logger lgr = Logger.getLogger("com"), lgr2 = Logger
			.getLogger("com.java2s"), util = Logger
			.getLogger("com.java2s.util"), test = Logger
			.getLogger("com.java2s.test"), rand = Logger.getLogger("random");

	private static void logMessages()
	{
		lgr.info(":com:info");
		lgr2.info("com.bruceeckel : info");
		util.info("util : info");
		test.severe("test : severe");
		rand.info("random : info");
	}

	public static void main(String[] args)
	{
		lgr.setLevel(Level.SEVERE);
		System.out.println("com level : SEVERE");
		logMessages();
		util.setLevel(Level.FINEST);
		test.setLevel(Level.FINEST);
		rand.setLevel(Level.FINEST);
		System.out.println("individual loggers set to FinEst");
		logMessages();
		lgr.setLevel(Level.SEVERE);
		System.out.println("com level:SEVERE");
		logMessages();
	}
}
