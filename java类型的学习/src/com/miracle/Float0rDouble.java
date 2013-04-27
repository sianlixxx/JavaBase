package com.miracle;

public class Float0rDouble
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Float m = new Float(3.4);
		System.out.println(m);
		float n = 3.4f;         //java默认的浮点数是double型
		System.out.println(n);
		System.out.println(Double.SIZE);   //SIZE 是指 The number of bits used
		System.out.println(1.0 / 0);   //正无穷大
		System.out.println(-1.0 / 0);	//负无穷大
		System.out.println(0.0 / 0);    //Not a Number ,负数开平方也是这结果
		System.out.println(Math.sqrt(-1.0));
		System.out.println(Double.NaN >  1.0 ); //false
		System.out.println(Double.NaN <= 1.0);  //false
		System.out.println(Double.NaN == Double.NaN); //false
		
		
	}

}
