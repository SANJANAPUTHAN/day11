package day11revision;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class ExceptionHandlingDemo {
public static void main(String[] args) throws Exception{
	Scanner sc=new Scanner(System.in);
	Dog dog=Dog.createObj();
	Child child=Child.createObj();
	System.out.println("Enter item name....");
	String itemname=sc.next();
	Item item=(Item)Class.forName(itemname).getConstructor().newInstance();
	child.playWithDog(dog, item);
	
}
}
class MyInvocationHandler implements InvocationHandler
{
	Object obj;
	public MyInvocationHandler(Object obj) {
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(obj, args);
	}
}
abstract class DogException extends Exception implements Cloneable
{
	public abstract void visit();
}
class DogBarkException extends DogException{
	static String msg;
	static DogBarkException db;
	public DogBarkException(String msg) 
	{
		this.msg=msg;
	}
	public static DogBarkException createObject(String string)
	{
		if(db==null)
		{
			db=new DogBarkException(string);
		}
		return db;
	}
	@Override
	public void visit() {
		Object obj=Proxy.newProxyInstance(Handler.class.getClassLoader(), new Class[] {Handler.class}, new MyInvocationHandler(new HandlerIndia()));
		((Handler) obj).handle(this);
	}
	@Override
	public String toString() {
		return msg;
	}
	public static DogBarkException createclone(DogBarkException db) throws Exception
	{
		return (DogBarkException)db.clone();
	}
	
}
class DogBiteException extends DogException  implements Cloneable {

	String msg;
	static DogBiteException db;
	public DogBiteException(String msg) 
	{
		this.msg=msg;
	}
	public static DogBiteException createObject(String string)
	{
		if(db==null)
		{
			db=new DogBiteException(string);
		}
		return db;
	}
	public static DogBiteException createclone(DogBiteException db) throws Exception
	{
		return (DogBiteException)db.clone();
	}
	@Override
	public void visit() {
		Object obj=Proxy.newProxyInstance(Handler.class.getClassLoader(), new Class[] {Handler.class}, new MyInvocationHandler(new HandlerIndia()));
		((Handler) obj).handle(this);
	}
	@Override
	public String toString() {
		return msg;
	}
	
}
interface Handler
{
	public void handle(DogBiteException db);
	public void handle(DogBarkException dbi);
}
class HandlerIndia implements Handler
{

	@Override
	public void handle(DogBiteException db) {
		System.out.println("send ambulance...");
		
	}

	@Override
	public void handle(DogBarkException dbi) {
		System.out.println("no action needed..");
		
	}
	
}
abstract class Item
{
	public Item()
	{
		
	}
	public abstract void execute() throws DogException;
}
class Stick extends Item
{
public Stick() {
}
	@Override
	public void execute() throws DogBiteException{
		throw DogBiteException.createObject("dog bite...");
		
	}
	
}
class Stone extends Item
{
public Stone() {
}
	@Override
	public void execute() throws DogBarkException {
		throw DogBarkException.createObject("dog bark...");
	}
	
}
class Dog  implements Cloneable
{
	static Dog dog;
	public static Dog createObj()
	{
		if(dog==null)
		{
			dog=new Dog();
		}
		return dog;
	}
	public static Dog createclone(Dog dog) throws Exception
	{
		return (Dog) dog.clone();
	}
	public void play(Item item) throws DogException
	{
		item.execute();
	}
}
class Child implements Cloneable
{
	static Child child;
	public static Child createObj()
	{
		if(child==null)
		{
			child=new Child();
		}
		return child;
	}
	public static Child createclone(Child child) throws Exception
	{
		return (Child)child.clone();
	}
	public void playWithDog(Dog dog,Item item)
	{
		try
		{
		dog.play(item);
		}
		catch(DogException d)
		{
			System.out.println(d);
			d.visit();
		}
	}
}