package chatQWERTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ChatServer {
	List<Socket> allSockets = new LinkedList<Socket>();
	List<Thread> allThreads;
	ServerSocket serverSocket;
	
	public ChatServer() {
		try {
			this.serverSocket = new ServerSocket();
			InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 5050);
			serverSocket.bind(isa);
			while (true) {			
				Socket newSocket = serverSocket.accept();

				Thread newThread = new Thread(new Runnable() {	
					@Override
					public void run() {
						try {
							sendToAllIfAvailable(newSocket);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				});
				newThread.start();		
				allSockets.add(newSocket);	
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	
	}
	
	public void sendToAllIfAvailable(Socket mainSocket) throws IOException {
		InputStream is = mainSocket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		while (true) {
			if (isr.ready()) {
				BufferedReader reader = new BufferedReader(isr);
				String line = reader.readLine();
				for (Socket socket : allSockets) {
					if (socket.equals(mainSocket)) {
					} else {
						OutputStream os = socket.getOutputStream();
						PrintWriter outt= new PrintWriter(os);
						char nlc = '\n';
						
						outt.print(line + nlc);
						outt.flush();
					}		
				}
			}
			else {	
			}
		}	
	}
	

}
