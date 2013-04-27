package com.rose;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HelloLog4j
{
	//private static Logger logger = Logger.getLogger(HelloLog4j.class.getName());
	private static Logger logger = Logger.getLogger("test");
	
	public static void main(String[] args)
	{
		PropertyConfigurator.configure("log4j.properties");
		// 记录debug级别的信息
		logger.debug("This is debug message.");
		// 记录info级别的信息
		logger.info("This is info message.");
		// 记录error级别的信息
		logger.error("This is error message.");
	}
}
