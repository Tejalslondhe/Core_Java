package com.Fruit_RTTI;

public class Apple extends Fruit {
	
	
	Apple(String color,double weight,String name,boolean fresh)
	{
		super(color,weight,name,fresh);
		
	}
	
	
	public String toString()
	{
		return super.toString();
	}
	
	
	public String taste()
	{
		return "sweet and sour";
	}
	
	
	public void jam()
	{
		System.out.println("Name: " + getName()+" making jam!");
	}
	

}
