package com.rose;

public class Bean
{
	private int x;
	private int y;
	public int z;
	String str = null;

	public Bean()
	{
		super();
		this.x =  1;
		this.y = 2;
		this.z = 3;
		this.str = "tqc";
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getZ()
	{
		return z;
	}

	public void setZ(int z)
	{
		this.z = z;
	}

	public String getStr()
	{
		return str;
	}

	public void setStr(String str)
	{
		this.str = str;
	}
}
