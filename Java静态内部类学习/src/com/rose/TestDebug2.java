package com.rose;

public class TestDebug2
{
    static TestDebug tb = new TestDebug(3);
    public static void main(String[] args)
    {
    	tb.output();
    	TestDebug.Test2.main(args);
    	TestDebug.Test2 t2 = new TestDebug.Test2(); 
    	TestDebug.Test1 t1 = tb.new Test1();
    	t2.Test();
    	t1.Test();
    	
//    	实例化静态内部类对象的模板是：  外部类类名.内部类类名 xxx = new 外部类类名.内部类类名()
//    	实例化非静态内部类对象的模板是：外部类类名.内部类类名 xxx = 外部类对象名.new 内部类类名()
    	
    }
}