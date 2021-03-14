package de.beam.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.json.JSONObject;

import de.beam.ChannelPoints.ChannelPoints;
import de.beam.ChannelPoints.WebPing;
import de.beam.utils.SetStreamTitel;
import de.beam.utils.TwitchChat;

public class checkbool extends Thread {
	public static boolean chatbool;
	public static boolean steamTitle;
	public static boolean ChannelPoits;
	public static boolean Rankingbool;

	
	
	public void run() {
	
		
		try {
				File file = new File("res/settings.txt");
				@SuppressWarnings("resource")
				Scanner s = new Scanner(file);
			        JSONObject j = new JSONObject(s.nextLine());
			        String chatString = j.getString("chatbool");
			        if(chatString.equalsIgnoreCase("true")) {
			        	chatbool = true;
			        }else {
			        	chatbool = false;
			        }
			        String steamTitleString = j.getString("steamTitel");
			        if(steamTitleString.equalsIgnoreCase("true")) {
			        	steamTitle = true;
			        }else {
			        	steamTitle = false;
			        }
			        String RankingboolString = j.getString("Rankingbool");
			        if(RankingboolString.equalsIgnoreCase("true")) {
			        	Rankingbool = true;
			        }else {
			        	Rankingbool = false;
			        }
			        String ChannelPoitsString = j.getString("ChannelPoits");
			        if(ChannelPoitsString.equalsIgnoreCase("true")) {
			        	ChannelPoits = true;
			        }else {
			        	ChannelPoits = false;
			        } 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		if(chatbool) {
			TwitchChat Chat = new TwitchChat();
			System.out.println("Starte TwitchChat");
			Chat.start();	
		}
		
		if(steamTitle) {
			SetStreamTitel St = new SetStreamTitel();
			System.out.println("Starte Stream Title Update");
			St.start();
		}	
		
		if(ChannelPoits) {
			ChannelPoints Po = new ChannelPoints();
			WebPing ping = new WebPing();
			
			System.out.println("Starte ChannelPoint Listener");
			System.out.println("Starte WebPing");
			Po.start();
			ping.start();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
