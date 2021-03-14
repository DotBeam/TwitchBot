package de.beam.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TwitchChat extends Thread {
	private static PrintWriter out;
	private static BufferedReader reader;
	
	public void run() {
		Socket chat = null;
		try {
			chat = new Socket("irc.twitch.tv", 6667);
			out = new PrintWriter(chat.getOutputStream(),true);
			reader = new BufferedReader(new InputStreamReader(chat.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		out.write("PASS oauth:"+keys.TwitchchatToken+ "\r\n");
		out.write("NICK "+keys.TwitchNick+" \r\n");
		out.write("JOIN #"+keys.TwitchNick.toLowerCase()+" \r\n");
		out.flush();
		
	    String s;
		try {
			while ((s = reader.readLine()) != null) {
				String[] as = s.split(":");
				String[] name = as[1].split("!");
				String msg = null;
				//msg.add(as);
				if(as[1].contains("004")) {
					System.out.println("Du bist Jetzt mit denn chat von "+keys.TwitchNick+ " verbunden.");
				}
				
				if(!as[1].contains("3") && !as[1].contains("00") ) {
					
				
				if(as.length >= 3) {
					msg = as[2];
					System.out.println(name[0]+": "+as[2]);
				}
			}
			
				if(msg == null) {
					
				}else {
					if(msg.equalsIgnoreCase("!help")) {
						SendMsg("Wie kann ich dir weiter helfen");
					}
				}
				
				
				
			
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void SendMsg(String msg) {
		out.write("PRIVMSG #bd_beam :"+msg+ "\r\n");
		out.flush();
		
		
	}

}
