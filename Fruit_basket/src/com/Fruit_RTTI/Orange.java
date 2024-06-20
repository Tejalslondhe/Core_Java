package com.Fruit_RTTI;

public class Orange extends Fruit {
	
	Orange(String color,double weight,String name,boolean fresh)
	{
		super(color,weight,name,fresh);
		
	}
	
	public String toString()
	{
		return super.toString();
	}
	
	
	public String taste()
	{
		return " sour";
	}
	
	
	public void juice()
	{
		System.out.println("Name: "+ getName()+ " Weight: "+ getWeight()+" Extracting Juice!");
	}
	
	

}
