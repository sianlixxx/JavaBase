package com.rose.LogLevel;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SettingTheLogLevel
{
	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger("com.mycompany");
		logger.setLevel(Level.INFO);
		logger.setLevel(null);
		logger.setLevel(Level.OFF);
		logger.setLevel(Level.ALL);
		//Getting the Log Level of a Logger
		Level level = logger.getLevel();
		while(null == level && logger.getParent() != null)
		{
			logger = logger.getParent();
			level = logger.getLevel();
		}
		
		logger.log(MyLevel.DISASTER, "my disaster messate");
		Level disaster = Level.parse("DISASTER");
		logger.log(disaster, "My Disaster message");
		
		 Logger log = Logger.getLogger("global");
		 log.setLevel(Level.WARNING);

		    log.finest("A");
		    log.finer("B");
		    log.fine("C");
		    log.config("D");
		    log.info("E");
		    log.warning("O");
		    if(log.isLoggable(Level.SEVERE))
		    {
		    	log.severe("A");
		    }
		    
		    Level level1 = Level.INFO;
		    Level level2 = Level.CONFIG;
		    if(level1.intValue() > level2.intValue())
		    {
		    	System.out.println("level1 is more severe");
		    }
		    else if(level1.intValue() < level2.intValue())
		    {
		    	System.out.println("level2 is more sever");
		    }
		    else
		    {
		    	System.out.println("level1 == levle2");
		    }
		    System.out.println("level1" +  level.intValue() + "\nlevel2" + level2.intValue());
	}
	@SuppressWarnings("serial")
	static class MyLevel extends Level
	{
		public static final Level DISASTER = new MyLevel("DISASTER", Level.SEVERE.intValue() +1);
		public MyLevel(String name, int value)
		{
			super(name, value);
		}
	}
}
