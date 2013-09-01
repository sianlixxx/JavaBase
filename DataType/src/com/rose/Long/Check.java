package com.rose.Long;

public class Check
{
	public static long addCheck(long a, long b)
	{
		return addCheck(a, b, "overflow:add");
	}

	public static long addCheck(long a, long b, String msg)
	{
		long ret;
		if (a > b)
		{
			ret = addCheck(b, a, msg);
		} else
		{
			if (a < 0)
			{
				if (b < 0)
				{
					if (Long.MIN_VALUE - b <= a)
					{
						ret = a + b;
					} else
					{
						throw new ArithmeticException(msg);
					}

				} else
				{
					ret = a + b;
				}
			} else
			{
				if (a <= Long.MAX_VALUE - b)
				{
					ret = a + b;
				} else
				{
					throw new ArithmeticException(msg);
				}
			}
		}
		return ret;
	}

	public static long mulCheck(long a, long b)
	{
		long ret;
		String msg = "overflow: multiply";
		if (a > b)
		{
			ret = mulCheck(b, a);
		} else
		{
			if (a < 0)
			{
				if (b < 0)
				{
					if (a >= Long.MAX_VALUE / b)
					{
						ret = a * b;
					} else
					{
						throw new ArithmeticException(msg);
					}
				} else if (b > 0)
				{
					if (Long.MIN_VALUE / b <= a)
					{
						ret = a * b;
					} else
					{
						throw new ArithmeticException(msg);
					}
				} else
				{
					ret = 0;
				}

			} else if (a > 0)
			{
				if (a <= Long.MAX_VALUE / b)
				{
					ret = a * b;
				} else
				{
					throw new ArithmeticException(msg);
				}

			} else
			{
				ret = 0;
			}
		}
		return ret;
	}

	public static long subAndCheck(long a, long b)
	{
		long ret;
		String msg = "overflow: subtract";
		if (b == Long.MIN_VALUE)
		{
			if (a < 0)
			{
				ret = a - b;
			} else
			{
				throw new ArithmeticException(msg);
			}
		} else
		{
			// use additive inverse
			ret = addAndCheck(a, -b, msg);
		}
		return ret;
	}

	/**
	 * Add two long integers, checking for overflow.
	 * 
	 * @param a
	 *            an addend
	 * @param b
	 *            an addend
	 * @param msg
	 *            the message to use for any thrown exception.
	 * @return the sum <code>a+b</code>
	 * @throws ArithmeticException
	 *             if the result can not be represented as an long
	 * @since 1.2
	 */
	private static long addAndCheck(long a, long b, String msg)
	{
		long ret;
		if (a > b)
		{
			// use symmetry to reduce boundry cases
			ret = addAndCheck(b, a, msg);
		} else
		{
			// assert a <= b

			if (a < 0)
			{
				if (b < 0)
				{
					// check for negative overflow
					if (Long.MIN_VALUE - b <= a)
					{
						ret = a + b;
					} else
					{
						throw new ArithmeticException(msg);
					}
				} else
				{
					// oppisite sign addition is always safe
					ret = a + b;
				}
			} else
			{
				// assert a >= 0
				// assert b >= 0

				// check for positive overflow
				if (a <= Long.MAX_VALUE - b)
				{
					ret = a + b;
				} else
				{
					throw new ArithmeticException(msg);
				}
			}
		}
		return ret;
	}
}
