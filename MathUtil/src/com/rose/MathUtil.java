package com.rose;

import java.math.BigDecimal;

public class MathUtil {
	private static final int DEF_DIV_SCALE = 10;
	private MathUtil()
	{
		
	}
	public static String add(String v1, String v2)
	{
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2  = new BigDecimal(v2);
		return String.valueOf(b1.add(b2));
	}
	public static String sub(String v1, String v2)
	{
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return String.valueOf(b1.subtract(b2));
	}
	
	public static String mul(String v1, String v2)
	{
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return String.valueOf(b1.multiply(b2));
	}
	public static String div(String v1, String v2)
	{
		return div(v1, v2, DEF_DIV_SCALE);
	}
	public static String div(String v1, String v2, int scale)
	{
		if(scale < 0)
		{
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
			
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return String.valueOf(b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP));
	}
	public static String round(String v, int scale)
	{
		if(scale < 0)
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		BigDecimal b = new BigDecimal(v);
		BigDecimal one = new BigDecimal("1");
		return String.valueOf(b.divide(one, scale, BigDecimal.ROUND_HALF_UP));
	}
	
	public static void main(String[] args)
	{
		String v1 = "20", v2 = "10000";
		int scale = 0;
		System.out.println(MathUtil.add(v1, v2) + "\n"+ MathUtil.div(v1, v2) + "\n"+ MathUtil.sub(v1, v2) + "\n"+ MathUtil.round("20.33344", scale));
		
		
	}
}
