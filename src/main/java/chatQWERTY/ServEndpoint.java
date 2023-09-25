package chatQWERTY;

import java.util.ArrayList;
import java.util.List;

import jakarta.websocket.CloseReason;
import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/my")
public class ServEndpoint extends Endpoint   {

	public void onOpen(Session session, EndpointConfig config) {
		SessionListner sl = new SessionListner();
		sl.registerSession(session);
		session.addMessageHandler(new MyHandler(sl.getAllSessions(),session));
	}
	
	 public void onClose(Session session, CloseReason closeReason) {
		 SessionListner sl = new SessionListner();
		 sl.removeSession(session);
		 
	 }
	
	







}
