package com.rose.DataTypeConversion;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ConversionUtil
{
	public static int toInt(Object object, int defaultValue)
	{
		if (null == object)
		{
			return defaultValue;
		} else if (object instanceof Number)
		{
			return ((Number) object).intValue();
		} else if (object instanceof String)
		{
			try
			{
				return Integer.parseInt((String) object);
			} catch (NumberFormatException ex)
			{
				ex.printStackTrace();
				return defaultValue;
			}
		}
		return defaultValue;
	}

	public static boolean toBoolean(Object object)
	{
		if (object instanceof Number)
		{
			return ((Number) object).intValue() != 0;
		}
		if (object instanceof Boolean)
		{
			return ((Boolean) object).booleanValue();
		}
		return object != null;
	}

	public static BigDecimal toBigDecimal(Object object) throws Exception
	{
		if (null == object)
		{
			return null;
		} else if (object instanceof BigDecimal)
		{
			return (BigDecimal) object;
		} else if (object instanceof BigInteger)
		{
			return new BigDecimal((BigInteger) object);
		} else if (object instanceof Number)
		{
			return new BigDecimal(((Number) object).doubleValue());
		}
		throw new Exception("Can't convert to BigDecimal: " + object);
	}

	@SuppressWarnings("rawtypes")
	public static Comparable toComparable(Object object)
	{
		if(null == object)
		{
			return null;
		}
		else if(object instanceof Comparable)
		{
			return (Comparable)object;
		}
		else if(object instanceof StringBuffer)
		{
			return object.toString();
		}
		else if(object instanceof char[])
		{
			return new String ((char[]) object);
			
		}
		else
		{
			throw new ClassCastException("Invalid Comparable class:" + object.getClass().getName());
		}
	}
	
	public static String toString(Object object)
	{
		if(null == object)
		{
			return null;
		}
		else if(object instanceof String)
		{
			return (String)object;
		}
		else if(object instanceof StringBuffer)
		{
			return object.toString();
		}
		else if(object instanceof char[])
		{
			return new String((char[])object);
		}
		else
		{
			throw new ClassCastException("Invalid class for String conversion" + object.getClass().getName());
		}
	}
	public static Object toUpperCase(Object object)
	{
		if((object instanceof String) || (object instanceof StringBuffer))
		{
			return object.toString().toUpperCase();
		}
		else if(object instanceof char[])
		{
			return new String((char[])object).toUpperCase();
		}
		else
		{
			return object;
		}
	}
}
