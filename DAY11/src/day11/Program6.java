package day11;


public class Program6 {
public static void main(String[] args) throws Exception {
	try
	{
		child child=new child();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	System.out.println("exception handled....");
	
}
}
class base 
{
	base() throws CustomException
	{
		throw new CustomException("base constructor exception....");
	}
}
class child extends base
{

	child() throws CustomException {
		super();
		throw new CustomException("child constructor exception....");
	}
	
}
class CustomException extends Exception
{
	String msg;
	public CustomException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}
}