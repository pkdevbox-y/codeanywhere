package meta.codeanywhere.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class APIContentInit extends HttpServlet {

	private static final long serialVersionUID = -2741902101740435993L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("API_Index"));
		String line = null;
		PrintWriter out = response.getWriter();
		while ((line = in.readLine()) != null) {
			out.write(line);
		}
		in.close();
		out.close();
	}
}
