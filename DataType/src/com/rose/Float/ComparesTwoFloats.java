package com.rose.Float;

public class ComparesTwoFloats
{
	public static int compare(float lhs, float rhs)
	{
		if(lhs < rhs)
		{
			return -1;
		}
		if(lhs > rhs)
		{
			return 1;
		}
		
		int lnsBits = Float.floatToIntBits(lhs);
		int rhsBites = Float.floatToIntBits(rhs);
		if( lnsBits == rhsBites)
		{
			return 0;
		}
		if(lnsBits  < rhsBites)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	public static void main(String[] args) {
	    double x = 11.635;
	    double y = 2.76;

	    System.out.printf("The value of e is %.4f%n", Math.E);
	    System.out.printf("exp(%.3f) is %.3f%n", x, Math.exp(x));
	    System.out.printf("log(%.3f) is %.3f%n", x, Math.log(x));
	    System.out.printf("pow(%.3f, %.3f) is %.3f%n", x, y, Math.pow(x, y));
	    System.out.printf("sqrt(%.3f) is %.3f%n", x, Math.sqrt(x));
	  }
}
