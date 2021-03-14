package Assignment3;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class A3_3 {
	//chat client
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader; //declare reader
	PrintWriter writer; //declare writer
	Socket sock; //socket for connection
	
	public static void main(String[] args) {
		System.out.println("Student ID : 2014722075"); //print ID
		System.out.println("Name : 이동준"); //print Name
		new A3_3().go();
		
	}
	public void go()
	{
		//make frame
		JFrame frame = new JFrame("Chat Client");
		JPanel namePanel = new JPanel();
		JLabel l = new JLabel("2014722075 이동준");
		namePanel.add(l);
		JPanel mainPanel = new JPanel();
		//TextArea of chat
		incoming = new JTextArea(15,30);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//textfield of input chat
		outgoing = new JTextField(20);
		//make button
		JButton sendButton = new JButton("Send");
		JButton clearButton = new JButton("Chat Clear");
		sendButton.addActionListener(new SendButtonListener());
		clearButton.addActionListener(new ClearButtonListener());
		mainPanel.add(qScroller);
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		mainPanel.add(clearButton);
		setUpNetworking(); //network
		
		int id = (int)(Math.random()*10 + 10);//id
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		//set of frame
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.getContentPane().add(BorderLayout.SOUTH,namePanel);
		frame.setSize(400, 500);
		frame.setVisible(true);
		
	}
	private void setUpNetworking()
	{//netwoking method
		try {
			sock = new Socket("127.0.0.1", 5000);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public class SendButtonListener implements ActionListener
	{//Listener of "send" Button
		public void actionPerformed(ActionEvent ev) {
			try {
				writer.println(outgoing.getText());
				writer.flush();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
			
		}
	}
	public class ClearButtonListener implements ActionListener
	{//Listener of "Clear" Button
		public void actionPerformed(ActionEvent ev) {
			try {
				incoming.setText("");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}
	
	public class IncomingReader implements Runnable
	{//read message
		public void run()
		{
			String message;
			try
			{//print message
				while((message = reader.readLine())!=null)
				{
					System.out.println("read " + message);
					incoming.append(message + "\n");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	
}


