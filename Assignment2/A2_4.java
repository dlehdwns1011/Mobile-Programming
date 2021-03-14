package Assignment2;

abstract class Electric
{//abstract class Electric
	//instance
	void nameofClass()
	{//print name of class method
		System.out.println("\n==Electric Class==");
	}
	abstract void printInstance(); //abstract method
	void printMethods()
	{//print methods
		System.out.println("Class has nameofClass(), printInstance(), printMethods()");
	}
}
class Smartphone extends Electric
{//class Smartphone extends Electric Class
	String S = "Galuxy S7";//member value
	void printInstance()
	{//print member instance method
		System.out.println("My Smartphone is "+S);
	}
}
class laptop extends Electric
{//class laptop extends Electric Class
	String S = "LG Gram";//member value
	void printInstance()
	{//print member instance method
		System.out.println("My laptop is "+S);
	}
}

abstract class Book
{//abstract class Book
	//instance
	void nameofClass()
	{//print name of class method
		System.out.println("\n==Book Class==");
	}
	abstract void printInstance();//abstract method
	void printMethods()
	{//print methods
		System.out.println("Class has nameofClass(), printInstance(), printMethods()");
	}
}

class Book1 extends Book
{//class Book1 extends Book
	String S = "Bible of Math";//member value
	void printInstance()
	{//print member instance method
		System.out.println("My Book1 is "+S);
	}
}
class Book2 extends Book
{
	String S = "Master of JAVA";//member value
	void printInstance()
	{//print member instance method
		System.out.println("My Book2 is "+S);
	}
}

public class A2_4 {
	public static void main(String[] args) { //main method
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		
		//make object and make new type
		Electric S = new Smartphone();
		Electric L = new laptop();
		Book A = new Book1();
		Book B = new Book2();
		//print Result
		System.out.println("< RESULT >");
		//call each methods
		S.nameofClass();
		S.printInstance();
		S.printMethods();
		L.nameofClass();
		L.printInstance();
		L.printMethods();
		A.nameofClass();
		A.printInstance();
		A.printMethods();
		B.nameofClass();
		B.printInstance();
		B.printMethods();
		
	}
}
