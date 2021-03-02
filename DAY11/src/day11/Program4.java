package day11;

import java.util.Scanner;

public class Program4 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a non leap year...");
	int year=sc.nextInt();
	try
	{
		leapyearmethod(year);
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	System.out.println("exeption handled...");
}

public static void leapyearmethod(int year) throws leapyearexception
{
	if(year%4==0)
	{
		throw new leapyearexception("enter non leap year...");
	}
	System.out.println("non Leap year...");
}
}

class leapyearexception extends Exception
{
	String str;
	public leapyearexception(String str)
	{
		this.str=str;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return str;
	}
	
}
/*Enter a non leap year...
2000
enter non leap year...
exeption handled...*/