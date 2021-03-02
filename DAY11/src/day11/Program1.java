package day11;

import java.util.Scanner;

public class Program1 {
public static void main(String[] args) {
	file file=new file();
	file.method("Sanjana");
}
}
class file
{
	public void method(String str)
	{
	Scanner sc=new Scanner(str);
	System.out.println(" "+sc.nextLine());
	sc.next();
	}
	
	
}

///it shows no such element exception