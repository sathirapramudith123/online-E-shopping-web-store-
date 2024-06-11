package LxServelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogOutServelet
 */
@WebServlet("/log-out")
public class LogOutServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			if(request.getSession().getAttribute("abcd") != null) {
				request.getSession().removeAttribute("abcd");
				response.sendRedirect("Home.jsp");
			}else {
				response.sendRedirect("Clothing.jsp");
			}
		}
	}

}
