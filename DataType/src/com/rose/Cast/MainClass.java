package com.rose.Cast;

class Animal
{
	public String toString()
	{
		return "This is an animal ";
	}
}

class Dog extends Animal
{
	public void sound()
	{
		System.out.println("Woof Woof");
	}
}

class Cat extends Animal
{
	public Cat(String aName)
	{
		name = aName;
	}

	public String toString()
	{
		return super.toString() + "\nIt's " + name + " the " + breed;
	}

	public void sound()
	{
		System.out.println("Miiaooww");
	}

	private String name;
	private String breed;
}

public class MainClass
{
	public static void main(String[] a)
	{
		Cat aPet = new Cat("Fang");
		Animal theAnimal = (Animal) aPet;
		System.out.println(theAnimal.toString());
	}

}
