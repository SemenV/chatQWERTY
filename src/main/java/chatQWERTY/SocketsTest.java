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
			new ChatClient();
			
			
		} else {
			new ChatServer();
		}


	
	}

}
