package com.rose.Test1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 	java用  @interface Annotation{ } 定义一个注解 @Annotation，一个注解是一个类。
	@Override，@Deprecated，@SuppressWarnings为常见的3个注解。
	注解相当于一种标记，在程序中加上了注解就等于为程序加上了某种标记，以后，
	JAVAC编译器，开发工具和其他程序可以用反射来了解你的类以及各种元素上有无任何标记，看你有什么标记，就去干相应的事。
 	注解@Retention可以用来修饰注解，是注解的注解，称为元注解。
	Retention注解有一个属性value，是RetentionPolicy类型的，Enum RetentionPolicy是一个枚举类型，
	这个枚举决定了Retention注解应该如何去保持，也可理解为Rentention 搭配 RententionPolicy使用。RetentionPolicy有3个值：CLASS  RUNTIME   SOURCE
	用@Retention(RetentionPolicy.CLASS)修饰的注解，表示注解的信息被保留在class文件(字节码文件)中当程序编译时，但不会被虚拟机读取在运行的时候；
	用@Retention(RetentionPolicy.SOURCE )修饰的注解,表示注解的信息会被编译器抛弃，不会留在class文件中，注解的信息只会留在源文件中；
	用@Retention(RetentionPolicy.RUNTIME )修饰的注解，表示注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时，
	所以他们可以用反射的方式读取。RetentionPolicy.RUNTIME 可以让你从JVM中读取Annotation注解的信息，以便在分析程序的时候使用.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(
{ ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE,
		ElementType.FIELD })
public @interface MyTarget
{

}
