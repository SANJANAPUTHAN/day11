package day11;

import java.util.Scanner;
import java.lang.ArithmeticException;
public class Program7 {
public static void main(String[] args) throws NumeratorException {
	Scanner sc=new Scanner(System.in);
	while(true)
	{
		System.out.println("Enter two numbers...");
		try
		{
			String numerator=sc.next();
			String denominator=sc.next();
			checkNumerator(numerator);
			int n=Integer.parseInt(numerator);
			int d=Integer.parseInt(denominator);
			int result=n/d;
			System.out.println(result);
		}
		catch(ArithmeticException e)
		{
			System.out.println("enter proper input.....");
		}
		catch(Exception e)
		{
			System.out.println("Enter proper values.....");
		}
			
		
	}
}


public static void checkNumerator(String numerator) throws NumeratorException
{
	String str=String.valueOf(numerator);
	if(str.startsWith("q") || str.startsWith("Q"))
	{
		throw new NumeratorException();
	}
}
}
class NumeratorException extends Exception
{
	public NumeratorException()
	{
		System.exit(0);
	}
	
}