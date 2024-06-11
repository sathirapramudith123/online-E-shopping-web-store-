package LxReview;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LxModel.User;

/**
 * Servlet implementation class getReviews
 */
@WebServlet("/getReviews")
public class getReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
			HttpSession session = request.getSession(false);
		
		if(session != null) {
			Object user = session.getAttribute("abcd");
			User loggedUser = (User) user;
			int uid = loggedUser.getuid();
			System.out.println(uid);
			
			
			List<Review> ReviewDetails = ReviewDBUtil.getALLReviews(uid);
			request.setAttribute("ReviewDetails", ReviewDetails);
			
			
			
			RequestDispatcher dis = request.getRequestDispatcher("review.jsp");
			dis.forward(request, response);
			
			
			
			
			
			
			
			
			
			
			
		}else {
			
			 out.println("<script type='text/javascript'>");
				out.println("alert('Please login !!');");
				out.println("location='login.jsp'");
				out.println("</script>");
			
		}
	}

}
