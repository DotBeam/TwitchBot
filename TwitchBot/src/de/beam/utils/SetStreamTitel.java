package de.beam.utils;

import java.io.IOException;
import de.beam.Get.TwitchGetter;
import de.beam.Get.TwitchSetter;

public class SetStreamTitel extends Thread{

	
	public void run() {
		
			try {
				sleep(120000);
				changeGame();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
	
	public void changeGame() throws IOException {

		if(!TwitchGetter.getgame(keys.TwitchNick).equalsIgnoreCase(SteamGame.game()) && SteamGame.game() != null) {
			System.out.println("nicht same");
			TwitchSetter.SetGame(SteamGame.game(), keys.TwitchNick);
			System.out.println("[Bot] Game Wurde auf "+SteamGame.game()+" Gesetzt Durch Steam");
		}
		run();
		
	}
	
	
	
	
	

}
