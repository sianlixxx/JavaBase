package com.rose;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

public class EmployeeCache
{
	private static EmployeeCache cache; //一个实例
	private Hashtable<String, EmployeeRef> employeeRefs; //存储cache
	private ReferenceQueue<Employee> q; //垃圾Reference的队列
	
	//继承SoftReference, 使得每一个实例都具有可以识别的标识,标识与HashMap的key相同
	private class EmployeeRef extends SoftReference<Employee>
	{
		private String _key = "";
		public EmployeeRef(Employee em, ReferenceQueue<Employee> q)
		{
			super(em, q);
			_key = em.getId();
		}
	}
	
	//构建一个缓存器实例
	private EmployeeCache()
	{
		employeeRefs = new Hashtable<String, EmployeeRef>();
		q = new ReferenceQueue<Employee>();
	}
	
	//取得缓存器实例
	private static EmployeeCache getInstance()
	{
		if(null == cache)
		{
			cache = new EmployeeCache();
		}
		return cache;
	}
	
	//以软引用的方式对一个Employee对象的实例进行引用并保存该引用
	private void cacheEmployee(Employee em)
	{
		cleanCache();//清除垃圾引用
		EmployeeRef ref = new EmployeeRef(em, q);
		employeeRefs.put(em.getId(), ref);
	}
	
	//根据ID，重新获取相应的Employee对象的实例
	public Employee getEmployee(String ID)
	{
		Employee em = null;
		//判断是否有该Employee实例的软引用，如果有就取得
		if(employeeRefs.containsKey(ID))
		{
				EmployeeRef ref = (EmployeeRef)employeeRefs.get(ID);
				em = (Employee)ref.get();
		}	
		
		//当取不到引用时，构建一个实例并且保存新实例的软引用
		if(null == em)
		{
			em = new Employee(ID);
			System.out.println("Retrieve From EmployeeInfoCenter. ID=\" + ID");
			this.cacheEmployee(em);
		}
		return em;
	}
	
	//清除那些软引用对象已经被回收的EmployeeRef对象
	private void cleanCache()
	{
		EmployeeRef ref = null;
		while((ref=(EmployeeRef)q.poll()) != null)
		{
			employeeRefs.remove(ref._key);
		}
	}
}
