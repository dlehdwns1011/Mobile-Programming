package Assignment3;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Checkbox
{//Class of Checkbox
	int sum = 0 ; //sum of price
	JLabel b; //print price
	JFrame frame = new JFrame(); // make frame
	JCheckBox[] c = new JCheckBox[5]; //make 5 checkboxs
	
	Checkbox()
	{//constructor method of Checkbox Class
		//set title of frame
		frame.setTitle("A3_4");
		//if close frame, exit the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//make Panel
		JPanel panel = new JPanel(); 
		//set Layout of panel -> BoxLayout
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		//make Label : print total price
		b = new JLabel("Total is "+sum,JLabel.CENTER);
		//set label border's color
		b.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		String[] name = new String[5];
		//price list
		name[0] = "Pizza                    10,000";
		name[1] = "Oil pasta	              7,500";
		name[2] = "Seafood pasta   8,000";
		name[3] = "Fried rice             6,000";
		name[4] = "Noodle                  4,000";
		for( int i = 0 ;i<5 ; i++)
		{//make checkbox.
			c[i] = new JCheckBox(name[i]);
			//set listener
			c[i].addItemListener(new MyItemListener());
			//insert checkbox in panel
			panel.add(c[i]);
		}
		//make label
		JLabel field = new JLabel("2014722075 이동준",JLabel.CENTER);
		field.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		//insert label(2014722075 이동준) in North of frame
		frame.getContentPane().add(BorderLayout.NORTH, field);
		//insert panel(checkboxs) in Center of frame
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		//insert label(total price) in South of frame
		frame.getContentPane().add(BorderLayout.SOUTH, b);
		//set size of frame
		frame.setSize(200,250);
		frame.setVisible(true);
	}
	class MyItemListener implements ItemListener
	{//Listener of checkbox
		public void itemStateChanged(ItemEvent e) {
			//if occurred Event
			int s = 1;
			if(e.getStateChange() == ItemEvent.SELECTED)
				s = 1; //if check
			else
				s = -1; //if not check
			//which checkbox event occured
			if( e.getItem() == c[0])//1st check box
				sum += s * 10000; //set price
			else if( e.getItem() == c[1])//2nd
				sum += s * 7500;
			else if( e.getItem() == c[2])//3rd
				sum += s * 8000;
			else if( e.getItem() == c[3])//4th
				sum += s * 6000;
			else if( e.getItem() == c[4])//5th
				sum += s * 4000;
			
			String r = String.format("%,d",sum);
			//set text in label using new total price
			b.setText("Total is "+r);
		}
		
	}
}

public class A3_4 {
	public static void main(String[] args) {
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : 이동준"); //print Name
		//call Checkbox()
		new Checkbox();
	}
}

