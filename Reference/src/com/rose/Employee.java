package com.rose;

public class Employee
{
	private String id;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	private String name;
	private String department;
	private String phone;
	private int slaary;
	private String origin;
	public Employee(String id)
	{
		this.id = id;
		getDataFromInfoCenter();
	}
	private void getDataFromInfoCenter()
	{
		//连接数据库，数据初始化
	}
}
