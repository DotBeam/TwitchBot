package de.beam.Get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import de.beam.utils.keys;

public class TwitchGetter {
	
	
	
	public static String gettitle(String Name) throws IOException {
		
		
		ArrayList<String> a = new ArrayList<String>();
		URL url = new URL("https://api.twitch.tv/kraken/channels/"+getUserID(Name));
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestMethod("GET");
		
		con.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
		con.setRequestProperty("Client-ID", keys.TwitchClientid);
		
		InputStream is = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        String[] b = br.readLine().split(",");
    	for(int i =0;i < b.length;i++) {
			 a.add(b[i]);
		}
    	return a.get(1).substring(10).replace('"', ' ');
		
		
	}
	public static String getgame(String Name) throws IOException {
		
		
		ArrayList<String> a = new ArrayList<String>();
		URL url = new URL("https://api.twitch.tv/kraken/channels/"+getUserID(Name));
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestMethod("GET");
		
		con.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
		con.setRequestProperty("Client-ID", keys.TwitchClientid);
		
		InputStream is = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        String[] b = br.readLine().split(",");
    	for(int i =0;i < b.length;i++) {
			 a.add(b[i]);
		}
    	return a.get(5).substring(8, a.get(5).length()-1);
		
		
	}

	public static String getv_cout() throws IOException {
		URL url = new URL("https://api.twitch.tv/kraken/streams/?game=Overwatch");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
		con.setRequestProperty("Client-ID", keys.TwitchClientid);
		
		InputStream is = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String inputLine;

        while ((inputLine = br.readLine()) != null) {
        	return inputLine;
        }
		return null;
		
	}
	public static String getUserID(String Name) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		URL url = new URL("https://api.twitch.tv/kraken/users?login="+Name);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/vnd.twitchtv.v5+json");
		con.setRequestProperty("Client-ID", keys.TwitchClientid);
		
		InputStream is = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);


        String[] b = br.readLine().split(",");
    	for(int i =0;i < b.length;i++) {
			 a.add(b[i]);
			 
		}
        return a.get(2).substring(7, 16);
		
		
	}
	public static ArrayList<String> User(String Channel) throws IOException{
		ArrayList<String> a = new ArrayList<String>();
		URL url = new URL("https://tmi.twitch.tv/group/user/"+Channel+"/chatters");
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		InputStream is = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        JSONObject j = new JSONObject(br.readLine());
        
        JSONObject json1 = (JSONObject) j.get("chatters");
        
        JSONArray  jsonArray = json1.getJSONArray("viewers");
        
        String s = jsonArray.toString().replace('"', ' ').replace("[", "").replace("]", "").replaceAll("\\s", "");
        
        String[] s1 = s.split(",");
        
        
        for(int i = 0; i< s1.length;i++) {
        	a.add(s1[i]);
        }

		return a;
	}
	
	
	 static int Validt(String token) throws IOException {
		URL url = new URL("https://id.twitch.tv/oauth2/validate");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestProperty("Authorization", "OAuth "+token);

		return http.getResponseCode();
	}
}
