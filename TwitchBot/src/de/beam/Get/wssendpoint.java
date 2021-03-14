package de.beam.Get;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import de.beam.ChannelPoints.ChannelPoints;
import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;



@ClientEndpoint
public class wssendpoint {

	private Session session;
	public wssendpoint() throws URISyntaxException, DeploymentException, IOException {
		URI uri = new URI("wss://pubsub-edge.twitch.tv:443");
		ContainerProvider.getWebSocketContainer().connectToServer(this,uri);
		
	}
	@OnOpen
	public void pOpen(Session session) {
		this.session = session;
	}
	@OnMessage
	public void pMsg(String msg) {
		
		try {
		 ChannelPoints.onmsg(msg);	
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void sendmsg(String msg) throws IOException {
		session.getBasicRemote().sendText(msg);
	}
	
	
	
}
