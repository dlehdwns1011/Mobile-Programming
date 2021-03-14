package one;

import java.util.Scanner;

public class A1_6 {
	public static void main(String[] args) { //main
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ÀÌµ¿ÁØ"); //print Name
		//a is 97 A is 65
		
		//for receive each value
		Scanner keyboard = new Scanner(System.in);
		String arr;
		System.out.print("Whar is your Name?: ");
		//enter name
		arr = keyboard.nextLine();
		char[] name = new char[100];
		//change shape (String -> char)
		name = arr.toCharArray();
		Change(name); //Go to Change method
		System.out.print("Hello, ");
		System.out.print(name);
		System.out.println(", nice to meet you!");
		
		
		keyboard.close();
	}
	public static void Change(char[] arr)
	{//if name has small alphabet, it will be changed to big alphabet
		for(int i = 0 ; i< arr.length ; i++)
		{//by using ASCII, check each alphabet
			int temp = arr[i];
			if(temp >= 97)
				arr[i] -= 32;
		}
	}

}

