package com.rose.NumberFormat;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

public class MainClass
{
	public static void main(String[] args)
	{
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		System.out.println(nf.getClass().getName());

		System.out.println(nf.format(1234111115));

		System.out.println(NumberFormat.getInstance(Locale.CHINA).format(
				123411115));
		Formatter fmt = new Formatter();

		// fmt.format("%1.4f", 1234567890.123456789);
		// System.out.println(fmt);
		fmt.format("%5.7s", "abcdefghijklmn");
		System.out.println(fmt);

		fmt.format("%5.7s", "abc");
		System.out.println(fmt);

		int number = 1500;

		String formatted = String.format("%07d", number);

		System.out.println("Number with leading zeros: " + formatted);

		NumberFormat nfs = NumberFormat.getInstance();
		for (double x = Math.PI; x < 100000; x *= 10)
		{
			String formattedNumber = nfs.format(x);
			System.out.println(formattedNumber + "\t" + x);
		}

		NumberFormat dollarFormat = NumberFormat
				.getCurrencyInstance(Locale.ENGLISH);
		double minimumWage = 5.15;

		System.out.println(dollarFormat.format(minimumWage));
		System.out.println(dollarFormat.format(40 * 52 * minimumWage));

		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setMinimumIntegerDigits(3);
		myFormat.setMaximumFractionDigits(2);
		myFormat.setMinimumFractionDigits(2);
		for (double d = 0.0; d < 36.0; d++)
		{
			String radianString = myFormat.format(Math.PI * d / 180.0);
			String gradString = myFormat.format(400 * d / 360);
			String degreeString = myFormat.format(d);
			System.out.println(degreeString + "  " + radianString + "  "
					+ gradString);
		}
		
		
	    FieldPosition fp = new FieldPosition(NumberFormat.INTEGER_FIELD);

	    System.out.println("Degrees  Radians  Grads");
	    for (double d = 0.0; d < 360.0; d++) {
	      String radianString = myFormat.format(Math.PI * d / 180.0, new StringBuffer(), fp)
	          .toString();
	      radianString = "   " + radianString;
	      String gradString = myFormat.format(400 * d / 360, new StringBuffer(), fp).toString();
	      gradString = "   " + gradString;
	      String degreeString = myFormat.format(d, new StringBuffer(), fp).toString();
	      degreeString = "   " + degreeString;
	      System.out.println(degreeString + "  " + radianString + "  " + gradString);
	    }
	    
	    NumberFormat percentFormat = NumberFormat.getPercentInstance(Locale.ENGLISH);
	    for (double d = 0.0; d <= 1.0; d += 0.05) {
	      System.out.println(percentFormat.format(d));
	    }
	}
}
