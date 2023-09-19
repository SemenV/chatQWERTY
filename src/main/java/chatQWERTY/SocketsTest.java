package chatQWERTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.ServerSocketChannel;

public class SocketsTest {

	public static void main(String[] args) throws IOException {

		test(args);
		
	}
		
		
		
		
		
	public static void test(String[] args) throws IOException {
		if (args[0].equals("0")) {
			try {
				Socket fs = new Socket();
				InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 5050);
				fs.connect(isa, 120000);
				
				
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
		if (args[0].equals("1")){
			

				ServerSocket ss = new ServerSocket();
				InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 5050);
				ss.bind(isa);
				Socket s1 = ss.accept();
				
				InputStream is = s1.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				
				

//				System.out.println(reader.readLine());
//				System.out.println();
				
				while (true) {
					if (isr.ready()) {
						BufferedReader reader = new BufferedReader(isr);
						System.out.println(reader.readLine());
					}
					else {
						
					}
				
				}
						
				

			
			
			
		}

	
	}

}
