package com.rose;

public class TestDebug
{
	private double num; // 必须添加为static 变量, 或方法 , 内部才可以访问

	public TestDebug(double in)
	{
		num = in;
	}

	public void output()
	{
		System.out.println(num);
	}

	class Test1
	{
		public void Test()
		{
			System.out.println("ok Test1");
		}
	}
	
	public static class Test2
	{
		public static void main(String[] args)
		{
			TestDebug td = new TestDebug(3.9);
			td.output();
		}
		public void Test()
		{
			System.out.println("ok Test2");
		}
	}
}