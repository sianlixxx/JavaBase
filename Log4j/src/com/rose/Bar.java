package com.rose;

import org.apache.log4j.Logger;

public class Bar
{
	static Logger logger = Logger.getLogger(Bar.class);

	public void doIt()
	{
		logger.debug("Did it again!");
	}

	public static void main(String[] args)
	{
		(new Bar()).doIt();
	}
}