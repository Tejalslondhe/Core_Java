package com.Fruit_RTTI;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		
		Fruit [] arr=new Fruit[10];
				
			
			
			while(true) {
				
			System.out.println("1.Add Apple");
			System.out.println("2.Add Mango");
			System.out.println("3.Add Orange");
			System.out.println("4.Display Names");
			System.out.println("5.Display all");
			System.out.println("6.Fresh fruits");
			System.out.println("7.Sour Fruits");
			System.out.println("8.Pulp/Juice/Jam");
			
			System.out.println("Enter choice:");
			
			int choice=sc.nextInt();
			
			
			
			switch(choice) 
			{			
			
			case 1:
			{
				System.out.println("Details of Apple");
				System.out.println("Enter Color: ");
				String color=sc.next();
				System.out.println("Enter Weight: ");
				double weight=sc.nextDouble();
				System.out.println("Enter Name: ");
				String name=sc.next();
				System.out.println("Fresh or not");
				boolean fresh=sc.nextBoolean();
				arr[Fruit.cnt++]=new Apple(color,weight,name,fresh);	
				break;
			}
			
			case 2:
			{
				System.out.println("Details of Mango");
				System.out.println("Enter Color: ");
				String color=sc.next();
				System.out.println("Enter Weight: ");
				double weight=sc.nextDouble();
				System.out.println("Enter Name: ");
				String name=sc.next();
				System.out.println("Fresh or not");
				boolean fresh=sc.nextBoolean();
				arr[Fruit.cnt++]=new Mango(color,weight,name,fresh);
				break;
			}
			
			case 3:
			{
				System.out.println("Details of Orange");
				System.out.println("Enter Color: ");
				String color=sc.next();
				System.out.println("Enter Weight: ");
				double weight=sc.nextDouble();
				System.out.println("Enter Name: ");
				String name=sc.next();
				System.out.println("Fresh or not");
				boolean fresh=sc.nextBoolean();
				arr[Fruit.cnt++]=new Orange(color,weight,name,fresh);
			    break;
			}
			
			case 4:
			{
				
				for(int i=0;i<Fruit.cnt;i++)
				{
				System.out.println(arr[i].getName());
				}
				break;
			}
				
			case 5:
			{
				for(int i=0;i<Fruit.cnt;i++)
				{
				System.out.println("Name:"  + arr[i].getName()+" Color: " + arr[i].getColor()+ " Weight: "+arr[i].getWeight());
				System.out.println(arr[i]);
				arr[i].taste();
				}
				break;
			}
			
			
			case 6:
			{
				System.out.println("Enter index");
				int index=sc.nextInt();
				
				if(index<0 && index>Fruit.cnt)
				{
					System.out.println("Invalid index");
				
				}
				else
				{
					
					if(arr[index].isFresh()==false)
					{
						System.out.println("Stale");
					}
				}
				break;
			}
			
			
			case 7:
			{
				for(int i=0;i<Fruit.cnt;i++)
				{
					String abc="sour";
					String xyz=arr[i].taste();
					boolean result=abc.equals(xyz);
					if (result == true)
					{
						System.out.println(arr[i].getName() + "is stale");
					}
			
				}
				break;
			}
			
				
			case 8:
			{
				for(int i=0;i<Fruit.cnt;i++) {
					
					
					if(arr[i] instanceof Apple)
					{
						Apple ap=(Apple)arr[i];
						ap.jam();
					}
					
					if(arr[i] instanceof Mango)
					{
						Mango mn=(Mango)arr[i];
						mn.pulp();
					}
					
					if(arr[i] instanceof Orange)
					{
						Orange og=(Orange)arr[i];
						og.juice();
					}
				}
				break;
			}
			
			case 9:
			
				return;
			
			
			
		}
		}
		
		}

}


