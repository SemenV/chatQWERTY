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
import java.net.UnknownHostException;

public class ChatServer {
	Thread chatReader;
	Thread chatWriter;
	ServerSocket ss;
	Socket fs;
	
	public ChatServer() {
		try {
			this.ss = new ServerSocket();
			InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 5050);
			ss.bind(isa);
			this.fs = ss.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		chatReader = new Thread(new Runnable() {
			@Override
			public void run() {
				consoleReadAndWriteSocket();
			}
		});
		
		
		chatWriter = new Thread(new Runnable() {
			@Override
			public void run() {
				socketReadAndWriteConsole();
			}
		});
		
		chatReader.start();
		chatWriter.start();
	
	}
	
	
	public void socketReadAndWriteConsole() {
		InputStream is;
		try {
			is = fs.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			while (true) {
				if (isr.ready()) {
					BufferedReader reader = new BufferedReader(isr);
					System.out.println(reader.readLine());
				}
				else {	
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void consoleReadAndWriteSocket() {
		try {
			OutputStream os = fs.getOutputStream();
			PrintWriter outt= new PrintWriter(os);
			
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			
			char nlc = '\n';
			
			while(true ) {
				outt.print(reader.readLine() + nlc);
				outt.flush();
			}
			

			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void listen() throws IOException {
//		ServerSocket ss = new ServerSocket();
//		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 5050);
//		ss.bind(isa);
//		Socket s1 = ss.accept();
//		
//		InputStream is = s1.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//
//		
//		while (true) {
//			if (isr.ready()) {
//				BufferedReader reader = new BufferedReader(isr);
//				System.out.println(reader.readLine());
//			}
//			else {
//				
//			}
//		
//		}
//	}
}
