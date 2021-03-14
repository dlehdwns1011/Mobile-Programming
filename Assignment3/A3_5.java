package Assignment3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class A3_5 implements ActionListener {
	int line = 0; //num of lines
	int word = 0; //num of words
	int chars = 0;//num of chars
	//each labels show number of each values
	JLabel l1 = new JLabel("Number of lines:    "+line,JLabel.CENTER);
	JLabel l2 = new JLabel("Number of words: "+word,JLabel.CENTER);
	JLabel l3 = new JLabel("Number of chars:  "+chars,JLabel.CENTER);
	//make text area
	JTextArea text = new JTextArea(5, 23);
	//make 2 buttons
	JButton button = new JButton("Process the Text");
	JButton button2 = new JButton("Clear the Text");
	
	public static void main(String[] args) {
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : 이동준"); //print Name
		//make object
		A3_5 gui = new A3_5();       
		gui.go();  //call go method
		
	}
	public void go()
	{//go method
		 //make Frame
		 JFrame frame = new JFrame();
		 //set title of frame
		 frame.setTitle("A3_5");
		 
		 //setting buttons
		 button.setSize(300, 30);
		 button2.setSize(300, 30);
		 //set listener of process button
		 button.addActionListener(this);
		//set listener of clear button
		 button2.addActionListener(new ActionListener()
		 {//listener of clear button
			 public void actionPerformed(ActionEvent e)
			 {//clear text area and reset each values
				text.setText("");
				line = 0; word = 0; chars = 0;
				l1.setText("Number of lines:    "+line);
				l2.setText("Number of words: "+word);
				l3.setText("Number of chars:  "+chars);
			 }
		 });
		 //if close frame, exit the program
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //make Panel
		 JPanel panel = new JPanel(); 
		 //insert buttons in panel
		 panel.add(button);
		 panel.add(button2);
		//set Layout of panel -> BoxLayout
		 panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		 //setting each labels
		 l1.setSize(300, 30);
		 l1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		 
		 l2.setSize(300, 30);
		 l2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		 
		 l3.setSize(300, 30);
		 l3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		 //insert each labels in panel
		 panel.add(l1);
		 panel.add(l2);
		 panel.add(l3);
		 
		 JLabel name = new JLabel("2014722075 이동준",JLabel.CENTER);
		 //make scrollbar including text area
		 JScrollPane scrollbar = new JScrollPane(text); 
		 text.setLineWrap(true);
		 //set
		 scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		 scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
		 //make panel2
		 JPanel panel2 = new JPanel();
		 //insert scrollbar in panel2
		 panel2.add(scrollbar);
		 
		 //insert panels and label in frame
		 frame.getContentPane().add(BorderLayout.CENTER, panel2);
		 frame.getContentPane().add(BorderLayout.SOUTH, panel);
		 frame.getContentPane().add(BorderLayout.NORTH, name);
		 //set size of frame
		 frame.setSize(300, 300); 
		 frame.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent ev) {
		//listener of process button
		line = 0; word = 0; chars = 0;

		String t = text.getText();
		char[] c = new char[t.length()];
		c = t.toCharArray();
		//find lines,words,chars
		for(int i = 0; i<t.length(); i++)
		{
			if(c[i] == ' ')
				word++;
			else if(c[i] == '\n' || i == t.length()-1)
			{
				line++; 
				if(c[i-1] != '\n'&&c[i-1] != ' ')
				{
					word++;
				}
			}
			if(c[i] != '\n' && c[i] != ' ')
				chars++;
				
		}
		//setting label using new each values
		l1.setText("Number of lines:    "+line);
		l2.setText("Number of words: "+word);
		l3.setText("Number of chars:  "+chars);
	}
}
