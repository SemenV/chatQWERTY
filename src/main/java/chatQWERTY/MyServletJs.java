package chatQWERTY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/js")
public class MyServletJs extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
throws IOException, ServletException
{
		response.setContentType("text/javascript");  
		try (InputStream in = getClass().getResourceAsStream("../../views/webSocketJs.html");
			    BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			    String res = reader.lines().collect(Collectors.joining());
			    PrintWriter out = response.getWriter();
			    out.println(res);
			    out.close();
			}


}
}
