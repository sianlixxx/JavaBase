package com.rose;
//实现观察的对象发生改变时通知多个观察者，在观察者和被观察者之间实现结果
public interface Observer
{
	//只要实现了这个接口对象就成为一个观察者
	public void dataUpdate(Model model);
}
