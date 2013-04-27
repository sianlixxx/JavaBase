package com.rose.LogFilter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
	public static void main(String args[])
	{
		Logger logger = Logger.getLogger("your.logging");
		AgeFilter filter = new AgeFilter();
		logger.setFilter(filter);
		CustomFilter person = new CustomFilter("your", 23);
		logger.log(Level.INFO, "Person has age" + person.getAge(), person);
	}
}