package com.rose.DataTypeConversion;

public class PrimitiveUtils
{
	public static Class getClass(String value)
	{
		Class clz = null;
		if ("int".equals(value))
		{
			clz = int.class;
		}
		if ("byte".equals(value))
		{
			clz = byte.class;
		}
		if ("short".equals(value))
		{
			clz = short.class;
		}
		if ("long".equals(value))
		{
			clz = long.class;
		}
		if ("float".equals(value))
		{
			clz = float.class;
		}
		if ("double".equals(value))
		{
			clz = double.class;
		}
		if ("boolean".equals(value))
		{
			clz = boolean.class;
		}
		if ("char".equals(value))
		{
			clz = char.class;
		}
		return clz;
	}

	public static Object read(String value, Class type)
	{
		Object ret = value;
		if (Integer.TYPE.equals(type))
		{
			ret = Integer.valueOf(value);
		}
		if (Byte.TYPE.equals(type))
		{
			ret = Byte.valueOf(value);
		}
		if (Short.TYPE.equals(type))
		{
			ret = Short.valueOf(value);
		}
		if (Long.TYPE.equals(type))
		{
			ret = Long.valueOf(value);
		}
		if (Float.TYPE.equals(type))
		{
			ret = Float.valueOf(value);
		}
		if (Double.TYPE.equals(type))
		{
			ret = Double.valueOf(value);
		}
		if (Boolean.TYPE.equals(type))
		{
			ret = Boolean.valueOf(value);
		}
		if (Character.TYPE.equals(type))
		{
			ret = value.charAt(0);
		}
		// TODO others.
		return ret;
	}
}
