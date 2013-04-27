package com.rose.Test2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnotation
{
	String hello() default "hello";
	String world();
	int[] array() default {2, 4, 6, 8};
	Class<?> style() default String.class;
	
	
}
