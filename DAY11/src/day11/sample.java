package day11;

public class sample {
public void method1()
{
	method2();
	System.out.println("caller...");
}
public void method2()
{
	try
	{
		return;
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
	sample sample=new sample();
	sample.method1();
}
}

//finally-method2
//caller...