package de.beam.Socketcon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SSocket extends Thread {
	

	public static ServerSocket ss;
	public static Socket socket;
	private static boolean con = false;

	
	public void run() {
		
		if(ss.isClosed()) {
			con = false;
		}else {
			con = true;
		}
		
		
		if(con) {}else {
			try {
				connect();
				System.out.println("Conect");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
			
			
			
		
		
	}
	
	
	private static void connect() throws IOException {
		
		ss = new ServerSocket(9329);
		socket = ss.accept();
		if(ss != null) {
			con = true;
		}
		
		
		
	}
	public static void sendMsg(String msg) {
		
		 try {
			PrintStream raus = new PrintStream(socket.getOutputStream());
			raus.print(msg);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public static String Getmsg() {
		
		  try {
			BufferedReader rein = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			return rein.readLine();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
}
