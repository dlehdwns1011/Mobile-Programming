package one;

import java.util.Scanner;

public class A1_2 {
	public static void main(String[] args) { //main
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		
		//for receive each value
		Scanner keyboard = new Scanner(System.in);
		//enter size of array
		System.out.print("Please enter size of array: ");
		int n = keyboard.nextInt();
		//make array(size is n)
		int []arr = new int[n];
		//enter numbers
		System.out.print("Please enter numbers: ");
		for(int i = 0; i<n; i++)
			arr[i] = keyboard.nextInt();
		//print result
		System.out.println("\n<Result>");
		//print before array
		System.out.println("Array Before Bubble Sort");
		for( int i = 0; i<n;i++)
			System.out.print(arr[i]+" ");
		//Go to BubbleSort method, array(arr) will be changed
		BubbleSort(arr,n);
		//print after array
		System.out.println("\nArray After Bubble Sort");
		for( int i = 0; i<n;i++)
			System.out.print(arr[i]+" ");
		
		keyboard.close();
	}
	
	public static void BubbleSort(int []arr ,int l)
	{//method for BubbleSort using descending
		//array has index that has value from 0 to l-1
		for(int i = 0;i<l-1;i++)
		{
			for(int j = 0;j<l-1;j++)
			{
				if(arr[j] < arr[j+1])
				{//if need to change value
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
					
			}
		}
	}
}
