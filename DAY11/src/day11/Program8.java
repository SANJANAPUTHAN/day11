package day11;

import java.util.Scanner;

public class Program8 {
	public static int getValue()
	{
		Scanner sc=new Scanner(System.in);
		int n = 0;
		try
		{
			n=sc.nextInt();
			if(n<0)
			{
				throw new NegativeNumberException("Enter positive value");
				
			}
			else if(n>100)
			{
				throw new LimitException("Enter values within range....");
				
			}
		}
		catch(NegativeNumberException e)
		{
			System.out.println(e);
			return 101;
		}
		catch(LimitException e)
		{
			System.out.println(e);
			return 101;
		}
		catch(Exception e)
		{
			System.out.println("Enter proper input...........");
			return 101;
		}
		return n;
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int marks=0,average=0;
	for(int i=0;i<5;i++)
	{
		int value=getValue();
		if(value==101)
		{
			i--;
		}
		else
		{
			marks=marks+value;
		}
	}
	average=marks/10;
	System.out.println(average);

}
}
class NegativeNumberException extends Exception
{
	String msg;
	public NegativeNumberException(String msg) {
		this.msg=msg;
		}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
}
class LimitException extends Exception
{
	String msg;
	public LimitException(String msg) {
		this.msg=msg;
		}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
}