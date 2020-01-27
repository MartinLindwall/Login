

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Servlet1")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if (username.equals("Ben") && password.equals("Stiller") || username.equals("Sandra") && password.equals("Bullock"))
		{
			out.print("Logged in! ");
			Cookie ck=new Cookie("name", username);
			
			response.addCookie(ck);
			if (username.equals("Ben"))
				{
					out.print("You were in the movie Tropic Thunder");				
				}
			if (username.equals("Sandra"))
				{
					out.print("You were in the movie Speed");
				}
		}
		else
		{
			out.print("Invalid username and/or password dumb-ass");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
