package one;

import java.util.Scanner;

public class A1_3 {
	public static void main(String[] args) { //main
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		//for receive each value
		Scanner keyboard = new Scanner(System.in);
		//enter row number
		System.out.println("Enter Number:");
		int n = keyboard.nextInt();
		//enter addition number
		System.out.println("Enter X:");
		int x = keyboard.nextInt();
		
		//print result
		System.out.println("\n<Result>");
		
		int i = 1; int count = 0;//start number is 0
		for(int r = 0 ; r < n ; r++)
		{//print row
			for(int c = 1 ; c <= i ; c++)
			{//print column
				System.out.print(count + "	");
				count+=x;//increase count
			}
			System.out.print("\n");
			i++;
		}
		keyboard.close();
	}

}
