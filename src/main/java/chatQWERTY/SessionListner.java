package chatQWERTY;

import java.util.ArrayList;
import java.util.List;

import jakarta.websocket.Session;

public class SessionListner  {
	
	private static List<Session> allSession = new ArrayList<Session>();
	private static Object lock = new Object();
	
	
	public SessionListner() {
	}
		
	
	public void  registerSession(Session currentSes) {
		synchronized (lock) {
			SessionListner.allSession.add(currentSes);
		}
	}
	
	public synchronized void removeSession(Session currentSes) {
		synchronized (lock) {
			for (Session ses : allSession) {
				if (ses.equals(currentSes)) {
					SessionListner.allSession.remove(currentSes);
				}
			}
		}
	}
	
	public synchronized List<Session> getAllSessions() {
		synchronized (lock) {
			return allSession;
		}
	}
	

}
