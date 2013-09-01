package com.rose.StringCharArray;

public class CharraySequence implements CharSequence
{
	private final char[] buff;
	private final int offset;
	private final int count;

	public CharraySequence(char[] buff, int offset, int count)
	{
		super();
		this.buff = buff;
		this.offset = offset;
		this.count = count;
	}

	public CharraySequence(char[] buff, int count)
	{
		this(buff, 0, count);
	}

	@Override
	public int length()
	{
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public char charAt(int index)
	{
		if (index < 0 || index >= count)
		{
			throw new StringIndexOutOfBoundsException(index);
		}

		return buff[offset + index];
	}

	@Override
	public CharSequence subSequence(int start, int end)
	{
		if(start < 0)
		{
			throw new StringIndexOutOfBoundsException(start);
		}
		if(end > count)
		{
			throw new StringIndexOutOfBoundsException(end);
		}
		if(start > end)
		{
			throw new StringIndexOutOfBoundsException(end - start);
		}
		
		return ((start == 0) && (end == count)) ? this : new CharraySequence(buff, offset + start, end - start);
	}

	public String toString()
	{
		return new String(this.buff, this.offset, this.count);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
