package com.rose;

import java.util.ArrayList;
import java.util.Iterator;

public class Model
{
	ArrayList<Data> data = new ArrayList<Data>();
	ArrayList<Object> observer = new ArrayList<Object>();

	public Model()
	{
		super();
	}

	public Model(int[] value, String[] name)
	{
		for (int i = 0; i < value.length; i++)
		{
			addData(value[i], name[i]);
		}
	}

	public Model(Data[] data)
	{
		for (int i = 0; i < data.length; i++)
		{
			addData(data[i]);
		}
	}

	public void addData(int value, String name)
	{
		Data data = new Data();
		data.value = value;
		data.name = name;
		this.data.add(data);
	}

	public void addData(Data data)
	{
		this.data.add(data);
	}

	public Data getData(int idx)
	{
		return (Data) (data.get(idx));
	}

	public int size()
	{
		return data.size();
	}

	//�Ǽǹ۲��ߣ�bserver
	public void registerObserver(Observer o)
	{
		observer.add(o);
	}

	public void removeObserver(Observer o)
	{
		observer.remove(o);
	}

	// �����ݸı�ʱ����Controller���ô˷�����֪ͨ����Observer,ˢ����ͼ.
	public void changeModel(Model model)
	{
		data.clear();
		for (int i = 0; i < model.size(); i++)
		{
			this.addData(model.getData(i));
		}
		dataUpdate();
	}

	private void dataUpdate()
	{
		for (Iterator<Object> i = observer.iterator(); i.hasNext();)
		{
			Observer o = (Observer) (i.next());
			o.dataUpdate(this);
		}
	}

}
