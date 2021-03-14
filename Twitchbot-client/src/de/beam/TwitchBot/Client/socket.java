package de.beam.TwitchBot.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class socket {

	public void sock() {
		
		 Socket socket = null;
	        try {
	            socket = new Socket("localhost", 9329);

	            
	            
	            
	           
	    }catch (Exception e) {
			e.getStackTrace();
		}
	}
		
		
	
	
}
