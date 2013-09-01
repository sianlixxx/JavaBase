package com.rose;

//:property.java
import java.util.*;
/** The first Thinking in java example program
* Lists system inronation on current machine
* @author tqcenglish
* @author com.rose
* @version 1.0
*/
public class Property
{
	/** Sole entry point to class & application
	 * @param args array of string arguments
	 * @return No return value
	 * @exception on exceptions No exceptions thrown
	 */
	public static void main(String[] args)
	{
		System.out.println(new Date());
		Properties p = System.getProperties();
		p.list(System.out);
		System.out.println("...Menory Usage:");
		Runtime rt = Runtime.getRuntime();
		System.out.println("Total menory = " + rt.totalMemory() + 
							"Free menory=" + rt.freeMemory());
	}

}///:~
