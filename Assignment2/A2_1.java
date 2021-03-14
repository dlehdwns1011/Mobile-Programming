package Assignment2;

import java.util.*;

public class A2_1 {
	public static void main(String[] args) { //main method
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		
		//for receive
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter number of data points: ");
		//Enter value
		int n = keyboard.nextInt(); //input number
		double[] arr = new double[n]; //make array
		double sum = 0; 
		for(int i = 0 ; i<n ; i++)
		{
			System.out.print("["+i+"]:");
			arr[i] = keyboard.nextDouble(); //enter values
			sum += arr[i]; //calculate sum of values
		}
		Arrays.sort(arr); //sort array
		double mean = sum/n; //calculate mean
		//print Result
		System.out.println("< RESULT >");
		String result = String.format("%.6f", mean);
		System.out.println("Statistical Information");
		System.out.println("=============================");
		//print mean since ~.xxxxxx
		System.out.println("Arithmetic mean:"+result);
		//print median using Median method
		System.out.println("Median:"+Median(arr,n));
		//print mode using Mode method
		System.out.println("Mode:"+Mode(arr,n));
		//print Standard deviation using Standard method
		System.out.println("Standard deviation:"+Standard(arr,n,mean));
		keyboard.close();
	}
	public static double Median(double[] arr,int n)
	{//calculate median method
		double median = 0;;
		if(n%2 == 0)//if size of array is even number
			median = (float)(arr[n/2]+arr[n/2-1])/2;
		else //else
			median = arr[n/2];
		
		return median;//return result
	}
	public static int Mode(double[] arr,int n)
	{//find mode method
		int mode = 0;int mcount = 0;int count = 0;
		for(int i = 0;i<n;i++)
		{
			count = 0;
			for(int j = 0; j<n ; j++)
			{//counting
				if(arr[i] == arr[j])
					count++;		
			}
			if(count > mcount)
			{//if need to change mode
				mcount = count;
				mode = (int)arr[i];
			}
		}
		return mode;//return result
	}
	public static String Standard(double[] arr, int n, double mean)
	{//calculate Standard deviation method
		double S1 = 0;
		double S2 = 0;
		//difference between the mean and sum of all
		for(int i = 0 ;i < n ; i++)
			S1 += Math.pow((float)arr[i]-mean, 2);
		S2 = Math.sqrt(S1/(n-1));//calculate square value
		String result = String.format("%.6f", S2);
		return result;//return result
	}
}
