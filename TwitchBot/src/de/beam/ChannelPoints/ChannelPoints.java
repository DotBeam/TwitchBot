package de.beam.ChannelPoints;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.json.JSONObject;

import de.beam.Get.TwitchGetter;
import de.beam.Get.wssendpoint;
import de.beam.utils.keys;
import jakarta.websocket.DeploymentException;

public class ChannelPoints extends Thread{

	
	private wssendpoint wss = null;
	public void run() {
		
		
		
		
		
		
		try {
		 wss = new wssendpoint();
			if(wss != null) {
				JSONObject json = new JSONObject();
				json.put("type", "PING");
				String msg = "{\"type\":\"LISTEN\",\"data\":{\"topics\": [\"channel-points-channel-v1."+TwitchGetter.getUserID(keys.TwitchNick.toLowerCase())+"\"],\"auth_token\": \""+keys.TwitchOAuth+"\"}}";
				wss.sendmsg(msg);
			
			}
			
		} catch (IOException | URISyntaxException | DeploymentException e) {
			e.printStackTrace();
		}
	
		
		
		
		
		
		
	}
	
	
		
	
	public static void onmsg(String msg) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		ArrayList<String> l = new ArrayList<String>();
		
		String[] a = msg.split(",");
		for(int i =0;i < a.length;i++) {
			 l.add(a[i]);
			 
		}
		if(l.size() > 10) {
			String b = l.get(12).substring(12, l.get(12).length()-2);
			
		
		if(b.equalsIgnoreCase("LetsGo")) {
			Sounds.PlaySound(2);
		}else if (b.equalsIgnoreCase("HOT")) {
			Sounds.PlaySound(1);
		}else if (b.equalsIgnoreCase("Busted")) {
			Sounds.PlaySound(3);
		}else if (b.equalsIgnoreCase("Illuminati")) {
			Sounds.PlaySound(4);
		}else if (b.equalsIgnoreCase("21")) {
			Sounds.PlaySound(5);
		}else if (b.equalsIgnoreCase("Nani")) {
			Sounds.PlaySound(6);
		}
			
		}
		
		
	
	}
	

	
	
}
