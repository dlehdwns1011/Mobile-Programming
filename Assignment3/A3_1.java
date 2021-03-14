package Assignment3;

import java.util.Scanner;

public class A3_1 {
	public static void main(String[] args) {
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		
		Scanner keyboard = new Scanner(System.in);
		//enter the size of array A
		System.out.print("Enter size of array A: ");
		int n = keyboard.nextInt();
		//make array
		int[] arr = new int[n];
		//enter numbers in array
		System.out.print("Enter numbers: ");
		for(int i = 0;i<n ; i++)
			arr[i] = keyboard.nextInt();
		//make object
		Solution S = new Solution();
		//call solution method in Solution Class
		int result = S.solution(arr);
		//print result
		System.out.print("Result: "+result);
		keyboard.close();
	}
}

class Solution 
{//Class of Solution
	public int solution(int[] A)
	{//solution method
		int count = 0; //count
		for(int i = 0 ; i<A.length ; i++)
		{//if already exist value in before index i, not count
		 //if not exist value in before index i, count
			boolean al = false;
			for(int j = i-1; j >=0 ; j--)
			{
				if(A[j] == A[i])
				{
					al = true;
				}
			}
			if( al == false )
				count++;
		}
		//return count
		return count;
	}
} 

