package de.beam.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class SteamGame {
	
	public static String UserID ="76561198261431671";
	public static String api ="6AA846B067AD387A3F5216E5B0C2C1DB";
	public static String key ="https://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2/?key="+api+"&format=json&steamids="+UserID;
	public static String infogameid = "https://api.steampowered.com/ILobbyMatchmakingService/GetLobbyData/v1/";
	
	public static String game() {
		ArrayList<String> msg = new ArrayList<>();
		
		
	
		try {
			 URL url = new URL(key);
			InputStream in = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String s = null;
			while ((s = reader.readLine()) != null) {	
				String[] a = s.split(",");
				for(int i =0;i < a.length;i++) {
					 msg.add(a[i]);
				}
				
				if(msg.size() > 16) {
					String t = msg.get(16).substring(17, msg.get(16).length()-1);
					return t;
				}
				
				
				
				}
				
				
				
			
				
					
				
			
			
				
				
				
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
		

	}

	
	

}
