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
 * Servlet implementation class loginServerlet
 */
@WebServlet("/user-login")
public class loginServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			String uName = request.getParameter("username");
			String uPassword = request.getParameter("password");
			
			if("admin".equals(uName) && "a123".equals(uPassword)) {
				User u = new User();
				u.setuName("Admin");
				request.getSession().setAttribute("u", u);
				response.sendRedirect("addProduct.jsp");
			}
			
			try {
				UserDao udao = new UserDao(DbCon.getConnection());
				User user = udao.userLogin(uName, uPassword);
				
				if(user != null) {
					request.getSession().setAttribute("abcd", user);
					List<User> cus = udao.getUser(uName);
					request.setAttribute("cus",cus);
					
					RequestDispatcher dis = request.getRequestDispatcher("MyAccount.jsp");
		            dis.forward(request, response);
					
				}else {
					response.sendRedirect("login.jsp");
					
				}
				
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		
			
		}
	}

}
