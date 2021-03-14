package one;

public class A1_4 {
	public static void main(String[] args) {
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		
		//make first die number using random function
		int a = (int)(Math.random()*6)+1;
		//make second die number using random function
		int b = (int)(Math.random()*6)+1;
		//print result
		System.out.print("\n<Result>\n");
		System.out.print("The first die comes up "+a); //print Name
		System.out.print("\nThe second die comes up "+b);
		int r = a + b;
		System.out.print("\nYour total roll is "+r);
	}
}
