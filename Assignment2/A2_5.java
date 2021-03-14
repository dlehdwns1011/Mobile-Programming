package Assignment2;

import java.util.*;

public class A2_5 {
	public static void main(String[] args) { //main method
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		
		//make ArrayList using Integer
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 0; i<10; i++)
		{//insert 10 numbers
			while(true)
			{//it is function to avoid duplication
				int temp = (int)(Math.random()*20)+1;
				if(!a.contains(temp))
				{
					a.add(temp);
					break;
				}
			}	
		}
		a.sort(null); //array sort
		System.out.println("List: "+a);
		System.out.print("Input your command: ");
		String c = ""; //input command
		Scanner keyboard = new Scanner(System.in);
		while(true)
		{
			c = keyboard.next(); //input command
			if(c.equals("a"))
			{//if command is a
				System.out.print("Input number to add: ");
				//input add number
				int addnum = keyboard.nextInt();
				ADD(a,addnum); //call ADD method
			}
			else if(c.equals("r"))
			{//if command is r
				System.out.print("Input number to remove: ");
				//input remove number
				int remnum = keyboard.nextInt();
				REMOVE(a,remnum); //call REMOVE method
			}
			else if(c.equals("s"))
			{//if command is s
				System.out.print("Input number to search: ");
				//input search number
				int seanum = keyboard.nextInt();
				SEARCH(a,seanum); //call SEARCH method
			}
			else //if command is e
				break; //end
			a.sort(null); //array sort
			System.out.println("List: "+a);
			System.out.print("Input your command: ");
			c = null;
		}
		System.out.println("<END> ");
		keyboard.close();
		
	}
	public static void ADD(ArrayList<Integer> a,int addnum)
	{//insert new number in ArrayList
		a.add(addnum);
	}
	public static void REMOVE(ArrayList<Integer> a,int remnum)
	{//remove number in ArrayList
		if(a.indexOf(remnum) == -1) //if not exist input number
			System.out.println("Not exist Number in array");
		else //if exist input number
			a.remove(a.indexOf(remnum));
	}
	public static void SEARCH(ArrayList<Integer> a,int seanum)
	{//search number in ArrayList
		if(a.indexOf(seanum) == -1) //if not exist input number
			System.out.println("Not exist Number in array");
		else //if exist input number
			System.out.println("Index of "+seanum+" is "+a.indexOf(seanum));
	}
}
