package chatQWERTY;

import java.util.ArrayList;
import java.util.List;

import jakarta.websocket.Session;

public class SessionListner  {
	
	private static List<Session> allSession = new ArrayList<Session>();

	public SessionListner() {
	}
		
	
	public void registerSession(Session currentSes) {
		SessionListner.allSession.add(currentSes);
	}
	
	public void removeSession(Session currentSes) {
		for (Session ses : allSession) {
			if (ses.equals(currentSes)) {
				SessionListner.allSession.remove(currentSes);
			}
		}
		
	}
	
	public List<Session> getAllSessions() {
		return allSession;
	}
	

}
