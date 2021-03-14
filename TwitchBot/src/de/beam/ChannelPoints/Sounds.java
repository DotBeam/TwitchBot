package de.beam.ChannelPoints;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
	
	
	public static void PlaySound(int number) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		
		if(number == 1) {
			File file = new File("res/HOT.wav");
			AudioInputStream as = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(as);
			clip.start();
		}else if(number == 2) {
			File file = new File("res/LetsGo.wav");
			AudioInputStream as = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(as);
			clip.start();
		}else if(number == 3) {
			File file = new File("res/Busted.wav");
			AudioInputStream as = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(as);
			clip.start();
		}else if(number == 4) {
			File file = new File("res/ILLUMINATI.wav");
			AudioInputStream as = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(as);
			clip.start();
		}else if(number == 5) {
			File file = new File("res/21.wav");
			AudioInputStream as = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(as);
			clip.start();
		}else if(number == 6) {
			File file = new File("res/nani.wav");
			AudioInputStream as = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(as);
			clip.start();
		}
		
		
		
		
	}

}
