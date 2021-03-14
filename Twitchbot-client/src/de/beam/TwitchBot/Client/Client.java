package de.beam.TwitchBot.Client;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client {

	public static void main(String[] args) {
		
		
		JFrame j = new JFrame("TwitchBot");
		j.setSize(500,1000);
		j.setVisible(true);
		j.setDefaultCloseOperation(3);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		j.add(panel);
		
		socket socket = new socket();
		socket.sock();
		

	}

}
