package LxReview;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LxModel.User;

/**
 * Servlet implementation class addReviewServlet
 */
@WebServlet("/addReview")
public class addReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String review = request.getParameter("review");
		
		System.out.println(name + email + rating +review);
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			Object user = session.getAttribute("abcd");
			User loggedUser = (User) user;
			int uid = loggedUser.getuid();
			System.out.println(uid);
			
			boolean isTrue = false ;
			
			try {
				isTrue = ReviewDBUtil.addReview(uid , name, email, rating, review);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			if(isTrue == true ) {
				 
				 out.println("<script type='text/javascript'>");
					out.println("alert('Review Added !!');");
					out.println("location='getReviews'");
					out.println("</script>");
				}else {
					out.println("<script type='text/javascript'>");
					out.println("alert(' unsuccess !!');");
					out.println("location='getReviews'");
					out.println("</script>");
				}
			
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert(' unsuccess !!');");
			out.println("location='Home.jsp'");
			out.println("</script>");
		}
	}

}
