package LxServelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LxCon.DbCon;
import LxDao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		
		UserDao udao = new UserDao(DbCon.getConnection());
		boolean isTrue = udao.insertUser(name, password, address, email, phone);
		
		if(isTrue == true) {
			 out.println("<script type='text/javascript'>");
				out.println("alert('Registered Successfully !!');");
				out.println("location = 'login.jsp' ");
				out.println("</script>");
		}else {
			 out.println("<script type='text/javascript'>");
				out.println("alert('Unsuccessfull registration !!');");
				out.println("location = 'Home.jsp' ");
				out.println("</script>");
		}
	}

}
