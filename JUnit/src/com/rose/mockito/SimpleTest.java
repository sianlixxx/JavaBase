package com.rose.mockito;

import java.util.Iterator;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;  

public class SimpleTest {

	public SimpleTest() {
		Iterator  i = mock(Iterator.class);
		when(i.next()).thenReturn("hello").thenReturn("world");
		String result = i.next() + " " + i.next();
		verify(i, times(2)).next();
		assertEquals("hello world", result);
	}
	public static void main(String[] args)
	{
		new SimpleTest();
	}

}
