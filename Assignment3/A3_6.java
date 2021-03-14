package Assignment3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class A3_6 {
	public static void main(String[] args) {
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : ¿Ãµø¡ÿ"); //print Name
		Scanner keyboard = new Scanner(System.in);
		while(true)
		{//loop
			System.out.println("\n\nNow Path is : 'c:/Users/'");
			System.out.print("Enter the Directory :");
			//insert path
			String path = keyboard.nextLine();
			if(path.equals("end"))
				break; //if enter the "end", exit
			String source = "c:/Users/";
			source = source + path; //make path
			System.out.println("< RESULT in "+source+">");
			subDirList(source); //call subDirList method
		}
		//end
		System.out.println("< END >");
		keyboard.close();
	}
	public static void subDirList(String p){
		File dir = new File(p); //make file object
		File[] fileList = dir.listFiles(); //assign list
		try{
			//visit all of files
			for(int i = 0 ; i < fileList.length ; i++){
				File file = fileList[i];
				
				if(file.isFile()){//if file
					//print file name
					if(!file.getParent().equals(p))
						System.out.println(i+1+": File name : " + file.getName());
					else
						System.out.println("\t - File name : " + file.getName());
				}
				else if(file.isDirectory()){ //if directory
					//print directory name
					if(!file.getParent().equals(p))
						System.out.println(i+1+": Directory name : " + file.getName());
					else
						System.out.println("\t - Directory name : " + file.getName());
					//recursive call if directory
					subDirList(file.getCanonicalPath().toString()); 
				}
			}
		}catch(IOException e) {		}
	}
}


