/**
 * DumpMethods.java
 */
package com.miracle.reflectiong.first;

import java.lang.reflect.Method;

/**
 * @author tqc
 *	2013-4-17下午11:53:56
 */
public class DumpMethods
{
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException
	{
		//加载并初始化命令行参数指定的类
		Class classType = Class.forName(args[0]);
		//得到类的所有方法
		Method methods[] = classType.getDeclaredMethods();
		for(Method method : methods)
		{
			System.out.println(method.toString());
		}
	}
}
