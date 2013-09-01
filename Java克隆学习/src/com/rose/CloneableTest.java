package com.rose;

public class CloneableTest implements Cloneable
{
	private String src = "src";

	public String getSrc()
	{
		return src;
	}

	public void setSrc(String src)
	{
		this.src = src;
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	public static void main(String[] args)
	{
		CloneableTest obj = new CloneableTest();
		try
		{
			CloneableTest objClone = (CloneableTest) obj.clone();
			assert obj.getClass() == objClone.getClass();
			assert obj != objClone;
			assert !obj.equals(objClone);
			assert new String("bac").equals(new String("bac"));
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
	}
}
