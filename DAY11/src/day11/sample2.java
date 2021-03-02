package day11;

public class sample2 {
public void method1()
{
	method2();
	System.out.println("caller...");
}
public void method2()
{
	try
	{
		System.exit(0);
	}
	catch(Exception e)
	{
		System.out.println("catch-method2");
	}
	finally
	{
		System.out.println("finally-method2");
	}
}
public static void main(String[] args) {
	sample2 sample=new sample2();
	sample.method1();
}
}
//it exits from the program