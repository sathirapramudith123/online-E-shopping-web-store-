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
 * Servlet implementation class deleteUserServlet
 */
@WebServlet("/delete-user")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String uid = request.getParameter("Uid");
		
		UserDao udo = new UserDao(DbCon.getConnection());
		boolean isTrue = udo.deleteUser(uid);
		
		if(isTrue == true) {
			 out.println("<script type='text/javascript'>");
				out.println("alert('User Delete  Successfully !!');");
				out.println("location = 'DeleteUser.jsp'");
				out.println("</script>");
		}else {
			List<User> uDetails = udo.getUserDetails(uid);
			request.setAttribute("uDetails", uDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);	
		}
		
	}

}
