package com.Fruit_RTTI;

public abstract class Fruit {
	
	private String color;
	private double weight;
	private String name;
	private boolean fresh;
	protected static int cnt=0;
	
	public Fruit(String color,double weight,String name,boolean fresh)
	{
		this.color=color;
		this.weight=weight;
		this.name=name;
		this.fresh=fresh;		
	}
	
	public abstract String taste();
	
	
	public String toString()
	{
		return "Color:"+this.getColor()+" Weight:"+ getWeight()+" Name:"+ getName() + " Fresh or not:"+ isFresh();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFresh() {
		return fresh;
	}

	public void setFresh(boolean fresh) {
		this.fresh = fresh;
	}
	

	
}
