package chatQWERTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	Thread chatReader;
	Thread chatWriter;
	Socket fs;
	
	public ChatClient() {
		this.fs = new Socket();
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 5050);
		try {
			fs.connect(isa, 120000);
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
}
