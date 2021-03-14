package Assignment2;


public class A2_2 {
	public static void main(String[] args) { //main method
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		
		//print Result
		System.out.println("< RESULT >");
		System.out.println("add(1 , 2) -> "+add(1,2));
		System.out.println("add(1 , 2 , 3) -> "+add(1,2,3));
		System.out.println("add(1.4 , 4.5) -> "+add(1.4,4.5));
		System.out.println("add(4 , 5 , 6) -> "+add(4,5,6));
		System.out.println("add(1.1 , 2.2 , 3.3) -> "+add(1.1,2.2,3.3));
		System.out.println("add(100 , 50) -> "+add(100,50));
	}
	//Method using overloading
	public static int add(int a,int b)
	{	return a+b;	} //2 integer addition
	public static int add(int a,int b, int c)
	{	return a+b+c; } //3 integer addition
	public static double add(double a,double b)
	{	return a+b;	} //2 double addition
	public static double add(double a,double b, double c)
	{	return a+b+c; } //3 double addition
}
