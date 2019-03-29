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
@WebServlet("/java-service/multiplier")
public class Multiplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random rd = new Random();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Multiplier() {
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
		String number1;
		String number2;
		//eine Default message ist 0
		int message = 0;
		//wenn Parameter übergeben werden:
		if((number1=request.getParameter("number1"))!=null && (number2=request.getParameter("number2"))!=null){
			message= Integer.parseInt(number1)
					* Integer.parseInt(number2);
		}
		
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

	// Allowing CORS copied by
	// https://www.logicbig.com/tutorials/java-ee-tutorial/java-servlet/servlet-cors.html
	//This is supposed to be more specific for certain Origins.
	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET");
	}
}

