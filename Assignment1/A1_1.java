package one;

import java.util.Scanner;

public class A1_1 {
	public static void main(String[] args) { //main method
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ÀÌµ¿ÁØ"); //print Name
		
		//for receive radius
		Scanner keyboard = new Scanner(System.in);
		//enter radius
		System.out.print("Please enter the radius of a circle: ");
		double radius = keyboard.nextFloat();
		// ¥ð
		double pie = 3.14159265;
		//calculate area of a circle by using r*r* ¥ð
		double area = (radius*radius*pie);
		//print result
		String result = String.format("%.6f", area);
		System.out.println("<Result>\nArea of a circle is " + result);
		
		keyboard.close();
	}
}


