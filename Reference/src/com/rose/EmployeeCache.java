package com.rose;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

public class EmployeeCache
{
	private static EmployeeCache cache; //һ��ʵ��
	private Hashtable<String, EmployeeRef> employeeRefs; //�洢cache
	private ReferenceQueue<Employee> q; //����Reference�Ķ���
	
	//�̳�SoftReference, ʹ��ÿһ��ʵ�������п���ʶ��ı�ʶ,��ʶ��HashMap��key��ͬ
	private class EmployeeRef extends SoftReference<Employee>
	{
		private String _key = "";
		public EmployeeRef(Employee em, ReferenceQueue<Employee> q)
		{
			super(em, q);
			_key = em.getId();
		}
	}
	
	//����һ��������ʵ��
	private EmployeeCache()
	{
		employeeRefs = new Hashtable<String, EmployeeRef>();
		q = new ReferenceQueue<Employee>();
	}
	
	//ȡ�û�����ʵ��
	private static EmployeeCache getInstance()
	{
		if(null == cache)
		{
			cache = new EmployeeCache();
		}
		return cache;
	}
	
	//�������õķ�ʽ��һ��Employee�����ʵ���������ò����������
	private void cacheEmployee(Employee em)
	{
		cleanCache();//�����������
		EmployeeRef ref = new EmployeeRef(em, q);
		employeeRefs.put(em.getId(), ref);
	}
	
	//����ID�����»�ȡ��Ӧ��Employee�����ʵ��
	public Employee getEmployee(String ID)
	{
		Employee em = null;
		//�ж��Ƿ��и�Employeeʵ���������ã�����о�ȡ��
		if(employeeRefs.containsKey(ID))
		{
				EmployeeRef ref = (EmployeeRef)employeeRefs.get(ID);
				em = (Employee)ref.get();
		}	
		
		//��ȡ��������ʱ������һ��ʵ�����ұ�����ʵ����������
		if(null == em)
		{
			em = new Employee(ID);
			System.out.println("Retrieve From EmployeeInfoCenter. ID=\" + ID");
			this.cacheEmployee(em);
		}
		return em;
	}
	
	//�����Щ�����ö����Ѿ������յ�EmployeeRef����
	private void cleanCache()
	{
		EmployeeRef ref = null;
		while((ref=(EmployeeRef)q.poll()) != null)
		{
			employeeRefs.remove(ref._key);
		}
	}
}
