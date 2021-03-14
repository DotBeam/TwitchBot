package de.beam.Get;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import de.beam.utils.keys;

public class TwitchSetter {
	
	public static void SetGame(String Game,String Channel) throws MalformedURLException, IOException {
		URL url = new URL("https://api.twitch.tv/kraken/channels/"+TwitchGetter.getUserID(Channel));
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("PUT");
		http.setDoOutput(true);
		http.setRequestProperty("Client-ID", keys.TwitchClientid);
		http.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
		http.setRequestProperty("Authorization", "OAuth "+keys.TwitchOAuth);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		String data = "channel[game]="+Game;

		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);
		http.getResponseCode();
		
	

		
	}


}
