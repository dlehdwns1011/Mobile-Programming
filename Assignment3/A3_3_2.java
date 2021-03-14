package Assignment3;

import java.io.*;
import java.net.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

public class A3_3_2 {
	//chat server
	ArrayList clientOutputStreams;
	
	public class ClientHandler implements Runnable
	{
		BufferedReader reader;
		Socket sock;
		long id;//id
		
		public ClientHandler(Socket clientSocket,long i)
		{
			id = i;
			try
			{//client connect server
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}

		public void run() {
			String message;
			try
			{//manage message
				while((message = reader.readLine())!=null)
				{
					System.out.println("read " + message);
					tellEveryone(message,id);
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args)
	{
		new A3_3_2().go();
	}
	
	public void go()
	{
		clientOutputStreams = new ArrayList();
		try
		{
			ServerSocket serverSock = new ServerSocket(5000);
			//make socket
			while(true)
			{//connection
				Socket clientSocket = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				long r = (long)(Math.random()*10);
				Thread t = new Thread(new ClientHandler(clientSocket,r));
				
				t.start();
				System.out.println("got a connection");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void tellEveryone(String message,long id)
	{//manage message
		Iterator it = clientOutputStreams.iterator();
		while(it.hasNext())
		{//send message
			try {
				PrintWriter writer = (PrintWriter) it.next();
				String ids = Long.toString(id);
				Date t = new Date();
				SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
				
				writer.println("["+time.format(t)+"] "+ids+" : "+message);
				writer.flush();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
