package Assignment3;

import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel
{//Class of MyDrawPanel, it is extended by JPanel
	public void paintComponent(Graphics g)
	{//paintComponent method
		//make face Circle. it's color is orange
		g.setColor(Color.orange);
		g.fillOval(30,30,200,200);
		//make eyes 2 Circles. it's color is white 
		g.setColor(Color.WHITE);
		g.fillOval(70,80,40,40);
		g.fillOval(150,80,40,40);
		//make nose triangle. it's color is white
		int x[] = { 120, 130, 140 }; 
		int y[] = { 160, 120, 160 };
		g.fillPolygon(x,y,3);
		//make mouse inverted triangle. it's color is white
		int x2[] = { 110, 130, 150 };
		int y2[] = { 180, 215, 180 };
		g.fillPolygon(x2,y2,3);
	}
}

public class A3_2 {
	public static void main(String[] args) {
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : 이동준"); //print Name
		//make object
		A3_2 GUI = new A3_2();
		//call go method
		GUI.go();
		
	}
	public void go()
	{//go method
		//make Frame
		JFrame frame = new JFrame();
		//if close frame, exit the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set title of frame
		frame.setTitle("A3_2");
		//make label
		JLabel label = new JLabel("2014722075 이동준",JLabel.CENTER);
		//make MyDrawPanel object
		MyDrawPanel S = new MyDrawPanel();
		//insert S(face) in Center of frame
		frame.getContentPane().add(BorderLayout.CENTER, S);
		//insert Label in North of frame
		frame.getContentPane().add(BorderLayout.NORTH,label);
		//set size of frame
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

