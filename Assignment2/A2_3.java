package Assignment2;

import java.util.*;

public class A2_3 {
	public static void main(String[] args) { //main method
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		
		//for receive
		Scanner keyboard = new Scanner(System.in);
		double[] arr = new double[100]; //make array
		System.out.print("Enter the numbers : ");
		int i = 0; int c = 0;
		//input numbers if input is 0, don't need to input
		for(i = 0; i<100 ; i++)
		{
			arr[i] = keyboard.nextDouble();
			if(arr[i] == 0)
				break;
		}

		double[] arr2 = new double[i];//make new array
		//copy numbers, new array has only number input by user
		for(c= 0 ; c < i ;c++)
			arr2[c] = arr[c]; 
		Arrays.sort(arr2); //sort array
		//print Result
		System.out.println("< RESULT >");
		for(int j = 1 ; j < c ;j++)
		{
			if(arr2[j-1] == arr2[j] && arr2[j] != arr2[j+1])
				System.out.print(arr2[j]+" ");
		}
		
		keyboard.close();
	}
}
