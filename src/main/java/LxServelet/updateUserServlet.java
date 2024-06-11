package LxServelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LxCon.DbCon;
import LxDao.UserDao;
import LxModel.User;

/**
 * Servlet implementation class updateUserServlet
 */
@WebServlet("/update-user")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String uid = request.getParameter("Uid");
		String uName = request.getParameter("Uname");
		String uPassword = request.getParameter("Upass");
		String uAddress = request.getParameter("Uadd");
		String uEmail = request.getParameter("Umail");
		String uPhone = request.getParameter("Uphone");
		
		UserDao ud = new UserDao(DbCon.getConnection());
		boolean isTrue = ud.updateUser(uid, uName, uPassword, uAddress, uEmail, uPhone);
		
		if(isTrue == true) {
			List<User> uDetails = ud.getUserDetails(uid);
			request.setAttribute("uDetails", uDetails);
			
			 out.println("<script type='text/javascript'>");
				out.println("alert('Update Successfully !!');");
				out.println("location = 'updateUser.jsp'");
				out.println("</script>");
		}else {
			List<User> uDetails = ud.getUserDetails(uid);
			request.setAttribute("uDetails", uDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);	
			
		}
	
	}

}
