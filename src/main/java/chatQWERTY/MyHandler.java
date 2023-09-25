package chatQWERTY;

import java.util.ArrayList;
import java.util.List;

import jakarta.websocket.MessageHandler;
import jakarta.websocket.Session;

public class MyHandler implements MessageHandler.Whole<String>{

	private static List<Session> allSession = new ArrayList<Session>();
	private Session currentSes;
	
	
	public MyHandler(List<Session> allSession, Session currentSes) {
		MyHandler.allSession = allSession;
		this.currentSes = currentSes;
		
	}
	
	
	@Override
	public void onMessage(String message) {  
		for (Session ses : allSession) {

			ses.getAsyncRemote().sendText(message);
			
			
		}
	}

}
