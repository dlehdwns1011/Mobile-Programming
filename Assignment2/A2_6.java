package Assignment2;

import java.util.Scanner;

public class A2_6 {
	public static void main(String[] args) { //main method
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		
		Boggle Game = new Boggle(); //make object of Boggle
		Game.Manager(); //call Manager method
		
	}
}
class Boggle
{//class of Boggle
	char[] grid; //grid
	boolean[] visited; //check visit
	Boggle()
	{//construction
		grid = new char[9]; //make array size of 9
		visited = new boolean[9];//make array
		//input grid and print
		System.out.println("--------------");
        
		for(int i = 0;i<9;i++)
		{
			grid[i] = (char)((Math.random()*26)+65);
			System.out.print("| "+grid[i]+" ");
			visited[i] = false;
			if(i==2||i==5||i==8)
				System.out.println("|\n--------------");
		}
		
	}
	
	void ShowGrid()
	{//print Grid method
		System.out.println("--------------");
		for(int i = 0;i<9;i++)
		{
			System.out.print("| "+grid[i]+" ");
			if(i==2||i==5||i==8)
				System.out.println("|\n--------------");
		}
	}
	void resetVisit()
	{//reset visited array method
		for(int i = 0;i<9;i++)
			visited[i] = false;
	}
	int Find(char f)
	{//find value in grid. if visited is false, return
		for(int i = 0; i<9 ; i++)
			if(f == grid[i])
				if(visited[i] == false)
					return i;
		return -1;
	}
	boolean FindPath(char[] word)
	{//find path method
		int n = word.length; int[] f = new int[n];
		int i = 0;  int count = 0;
		f[0] = Find(word[0]);
		if(f[0] == -1)
			return false;	
		i++; int temp = -1; int bfs = -1;
		visited[f[0]] = true;
		while(true)
		{
			if(i == n)
				break;
			f[i] = Find(word[i]);
			if(i == 0)
			{
				if(f[0] == -1 || bfs == f[0])
					return false;
				resetVisit();
				visited[f[0]] = true;
				i++;
				continue;
			}
			if(f[i] == -1)
			{
				if(temp != -1)
				{
					visited[temp] = false;
					temp = -1;
				}
				i--; temp = f[i];
				if(i == 0 && count == 0)
				{
					bfs = f[i]; count++;
					resetVisit();
				}
				visited[f[i]] = true;
			}
			else
			{
				if(CanNext(f[i-1],f[i]))
				{
					
					visited[f[i]] = true;
					if(temp != -1 && temp != f[i])
					{
						visited[temp] = false;
						temp = -1;
					}
					i++;
				}
				else
				{
					visited[f[i]] = true;
					temp = f[i];
				}
			}
		}
		return true; //exist
	}
	
	boolean Exist(char[] word)
	{//check if path is exist or not
		if(FindPath(word))
			return true;
		return false;
	}
	boolean CanNext(int i,int j)
	{//check link of grid method
		if(i == 0) {
			if(j ==1||j==3||j==4)
				return true;
		}else if(i == 1){
			if(j==0||j==2||j==3||j==4||j==5)
				return true;
		}else if(i == 2){
			if(j==1||j==4||j==5)
				return true;
		}else if(i == 3){
			if(j==0||j==1||j==4||j==6||j==7)
				return true;
		}else if(i == 4){
				return true;
		}else if(i == 5){
			if(j==1||j==2||j==4||j==7||j==8)
				return true;
		}else if(i == 6){
			if(j==3||j==4||j==7)
				return true;
		}else if(i == 7){
			if(j==3||j==4||j==5||j==6||j==8)
				return true;
		}else if(i == 8){
			if(j==4||j==5||j==7)
				return true;
		}
		return false;
	}
	void Manager()
	{//game manager
		Scanner keyboard = new Scanner(System.in);
		String Word;
		while(true)
		{
			System.out.print("Input word: ");
			Word = keyboard.next(); //input word
			if(Word.length() < 3)
			{//if word's size is < 3
				System.out.println("!!Input word is at least three letters!!");
				continue; //error
			}
			if(Word.equals("END")) //if input is END
				break;//end
			if(Word.equals("GRID")) //if input is GRID
			{
				ShowGrid(); //call show grid method
				continue;
			}
			//start game
			int size = Word.length();
			char[] w = new char[size];
			w = Word.toCharArray();
			if(Exist(w) == true)
				System.out.println("Exist");
			else
				System.out.println("Non-Exist");
			resetVisit();
		}
		System.out.println("END OF GAME");
		keyboard.close();
	}
}



