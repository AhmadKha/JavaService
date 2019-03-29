package JavaServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavaService
 */
@WebServlet("/java-service/nextNr")
public class JavaService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rd = new Random();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JavaService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("request");
		setAccessControlHeaders(response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int message = ((rd.nextInt(1) == 0) ? (rd.nextInt()) : (-rd.nextInt()));
		// out.println("<html><body>");
		out.println(message);
		System.out.println(message);
		// out.println("</html></body>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void destroy() {
		// do nothing.
	}

	//Allowing CORS copied by https://www.logicbig.com/tutorials/java-ee-tutorial/java-servlet/servlet-cors.html
	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET");
	}
}
