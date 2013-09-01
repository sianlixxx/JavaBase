package com.miracle.reflectiong.beanutils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class BeanReflect
{
	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			IntrospectionException, NoSuchMethodException
	{
		Bean bean = new Bean();
		getProperty(bean, "x");
		getProperty1(bean, "x");
		// BeanUtils PropertyUtils 的getProperty 区别在返回值
		BeanUtils.setProperty(bean, "x", "23");
		System.out.println(BeanUtils.getProperty(bean, "x"));
		PropertyUtils.setProperty(bean, "x", 24);
		System.out.println(PropertyUtils.getProperty(bean, "x"));
	}

	/**
	 * new PropertyDescriptor
	 * 
	 * @param bean
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void getProperty1(Bean bean, String propertyName)
			throws IntrospectionException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{
		PropertyDescriptor pd = new PropertyDescriptor("x", bean.getClass());
		Method methodGet = pd.getReadMethod();
		System.out.println("this value is " + methodGet.invoke(bean));
	}

	/**
	 * Introspector.getBeanInfo
	 * 
	 * @param bean
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void getProperty(Bean bean, String propertyName)
			throws IntrospectionException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{
		BeanInfo beanInfo = Introspector.getBeanInfo(Bean.class);
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds)
		{
			if (pd.getName().equals(propertyName))
			{
				Method methodSetX = pd.getWriteMethod();
				methodSetX.invoke(bean, 5);
				Method methodGetX = pd.getReadMethod();
				System.out.println("the value is " + methodGetX.invoke(bean));
				break;
			}
		}
	}
}
