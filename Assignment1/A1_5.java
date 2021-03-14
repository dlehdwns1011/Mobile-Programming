package one;

public class A1_5 {
	public static void main(String[] args) { //main
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ÀÌµ¿ÁØ"); //print Name
		
		Digit object = new Digit(); //declare Digit object
		//result : total 6 cases
		System.out.print("lastDigit(23, 19, 13) -> ");
		System.out.println(object.lastDigit(23,19,13)); 
		System.out.print("lastDigit(23, 19, 12) -> ");
		System.out.println(object.lastDigit(23,19,12)); 
		System.out.print("lastDigit(23, 19, 3) -> ");
		System.out.println(object.lastDigit(23,19,3));
		System.out.print("lastDigit(100, 20, 52) -> ");
		System.out.println(object.lastDigit(100,20,52));
		System.out.print("lastDigit(1024, 32, 16) -> ");
		System.out.println(object.lastDigit(1024,32,16));
		System.out.print("lastDigit(1234, 5678, 10) -> ");
		System.out.println(object.lastDigit(1234,5678,10));
		
	}
}

class Digit{ //class of Digit
	int a,b,c; //declare for finding last digit
	
	boolean lastDigit(int i,int j,int k)
	{//check each digit method
		a = i%10; b = j%10; c = k%10; //make last digit
		if(a==b || b==c || a==c) //compare each last digit
			return true; //if ok. return ture
		return false;	//else return false
	}
}
