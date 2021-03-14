package de.beam.ChannelPoints;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONObject;

import de.beam.Get.wssendpoint;
import de.beam.main.checkbool;
import jakarta.websocket.DeploymentException;

public class WebPing extends Thread{
	
	
	@Override
	public void run() {
	
		
		try {
			sleep(420000);
			Ping();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void Ping() {
		
		try {
			JSONObject json = new JSONObject();
			json.put("type", "PING");
			wssendpoint wss = new wssendpoint();
			wss.sendmsg(json.toString());
		} catch (URISyntaxException | DeploymentException | IOException e) {
			e.printStackTrace();
		}
		if(checkbool.ChannelPoits) {
			run();
		}
		
	}
	
	
	

}
