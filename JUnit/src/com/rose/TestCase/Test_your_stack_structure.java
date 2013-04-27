package com.rose.TestCase;

import junit.framework.TestCase;

public class Test_your_stack_structure extends TestCase
{
	MyStack myStack = new MyStack();
	public void testEmpty()throws Exception
	{
		myStack.checkInvariant();
		myStack.push("sample");
		myStack.checkInvariant();
		
		assertEquals("sample", myStack.pop());
		myStack.checkInvariant();
		myStack.push("test");
		
		myStack.delete(1);
		myStack.checkInvariant();
	}
}
class MyStack
{
	private int next_index;
	private String[] stack;
	
	public MyStack()
	{
		
		this.next_index = 0;
		this.stack = new String[100];;
	}
	public String pop()
	{
		return stack[--next_index];
	}
	public void delete(int n)
	{
		next_index -= n;
	}
	public void push(String str)
	{
		stack[next_index++] = str;
	}
	public String top()
	{
		return stack[next_index - 1];
	}
	public void checkInvariant() throws Exception
	{
		if(!(next_index >= 0 && next_index <= stack.length))
		{
			throw new Exception("next_index out of range: " + next_index + " for stack length "
			          + stack.length);
		}
	}
	
	
}
