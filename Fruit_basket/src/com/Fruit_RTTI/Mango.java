package com.Fruit_RTTI;

public class Mango extends Fruit{
	
	Mango(String color,double weight,String name,boolean fresh)
	{
		super(color,weight,name,fresh);
		
	}
	
	public String toString()
	{
		return super.toString();
	}
	
	
	public String taste()
	{
		return "sweet";
	}
	
	
	public void pulp()
	{
		System.out.println("Name: "+ getName()+ "Color: "+ getColor()+" Creating Pulp!");
	}

}
