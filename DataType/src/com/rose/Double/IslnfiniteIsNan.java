package com.rose.Double;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

public class IslnfiniteIsNan
{
	public static void main(String args[])
	{
		Double d1 = new Double(1 / 0.);
		Double d2 = new Double(0 / 0.);
		System.out.println(d1 + ":" + d1.isInfinite() + d1.isNaN());
		System.out.println(d2 + ":" + d2.isNaN() + d2.isInfinite());

		double d = Math.sqrt(-10);
		boolean b1 = Double.isNaN(d);

		System.out.println(b1);

		Double dObj = new Double(d);
		boolean b2 = dObj.isNaN();
		System.out.println(b2);
		long n = 461012;
		System.out.format("%d%n", n);
		System.out.format("%08d%n", n);
		System.out.format("%+8d%n", n);
		System.out.format("%,8d%n", n);
		System.out.format("%+,8d%n%n", n);

		double pi = Math.PI;
		System.out.format("%f%n", pi);
		System.out.format("%.3f%n", pi);
		System.out.format("%10.3f%n", pi);
		System.out.format("%-10.3f%n", pi);
		System.out.format(Locale.FRANCE, "%-10.4f%n%n", pi);

		Calendar c = Calendar.getInstance();
		System.out.format("%tB %te, %tY%n", c, c, c);
		System.out.format("%tl:%tM %tp%n", c, c, c);
		System.out.format("%tD%n", c);
		

	    customFormat("###,###.###", 123456.789);
	    customFormat("###.##", 123456.789);
	    customFormat("000000.000", 123.78);
	    customFormat("$###,###.###", 12345.67);
	    
	    System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        
        double dd = 5.0;
        dd *= 4.0;
        System.out.println("dd = " + dd);
        System.out.println("Ternary: " + (dd == 5 ? "yes" : "no"));
        
        Double doub = new Double("50.0");
        System.out.println(doub);
        System.out.println(doub.toString());
        System.out.println(Double.parseDouble("50.0"));
        System.out.println(Double.valueOf(50.0).doubleValue());
	}
	static public void customFormat(String pattern, double value) {
	    DecimalFormat myFormatter = new DecimalFormat(pattern);
	    String output = myFormatter.format(value);
	    System.out.println(value + "  " + pattern + "  " + output);
	  }
}
