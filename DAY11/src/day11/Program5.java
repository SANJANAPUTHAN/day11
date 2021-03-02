package day11;

import java.util.Scanner;

public class Program5 {
public static void main(String[] args) throws evennumberexception {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter a even number...");
	int year=sc.nextInt();
	evennumbermethod(year);
	System.out.println("Exception handled...");
}

public static void evennumbermethod(int year) throws evennumberexception {
	if(year%2!=0)
	{
		throw new evennumberexception("enter even number...");
	}
	System.out.println("Even number...");
	
}
}

class evennumberexception extends Exception
{
	String string;

	public evennumberexception(String string) {
		this.string=string;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return string;
	}
	
}


/*Enter a even number...
3
Exception in thread "main" enter even number...
	at day11.Program5.evennumbermethod(Program5.java:17)
	at day11.Program5.main(Program5.java:10)abstract

*/