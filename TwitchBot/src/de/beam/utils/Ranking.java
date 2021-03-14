package de.beam.utils;

import java.io.IOException;
import java.util.ArrayList;

import de.beam.Get.TwitchGetter;

public class Ranking extends Thread {

	
	public void run() {
		
		try {
			sleep(500);
			check();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	public ArrayList<String> oldlist = new ArrayList<String>();
	public ArrayList<String> newlist = new ArrayList<String>();
	public boolean isonline = true;
	public void check() throws IOException {
		if(isonline) {
		
		if(oldlist.size() == 0) {
			
				oldlist = TwitchGetter.User(keys.TwitchNick.toLowerCase());
				run();
			
		}else {
			
			newlist = TwitchGetter.User(keys.TwitchNick.toLowerCase());
			for (int x = 0; x < oldlist.size(); x++ ) {
				
				 for (int y = 0; y < newlist.size(); y++) {
					 if (oldlist.get(x).equalsIgnoreCase(newlist.get(y))) {
						 System.out.println("ist gleich "+oldlist.get(x));						 
						
						
					 }
				 }
				
				
			}
			 oldlist.clear();
			 oldlist = newlist;
			 newlist.clear();

			 run();
			
			
			
			
		}
		
		
		
		
	}else {
		run();
	}
	}
	
	
}
