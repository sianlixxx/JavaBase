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
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public static void main(String[] args)
	{

		CloneableTest obj = new CloneableTest();

		try
		{

			CloneableTest objClone = (CloneableTest) obj.clone();

			System.out.println("class same: "
					+ (obj.getClass() == objClone.getClass()));

			System.out.println("obj same: " + (obj == objClone));

			System.out.println("obj equlas: " + (obj.equals(objClone)));

			System.out.println(new String("bac").equals(new String("bac")));

		} catch (CloneNotSupportedException e)
		{

			e.printStackTrace();

		}

	}
}
