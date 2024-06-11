package LxContact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LxModel.User;

@WebServlet("/sendMessage")
public class sendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		System.out.println(name + email +message);
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			Object user = session.getAttribute("abcd");
			User loggedUser = (User) user;
			int uid = loggedUser.getuid();
			System.out.println(uid);
			
			boolean isTrue = false ;
			
			try {
				isTrue = ContactUsDBUtil.addMessage(uid , name, email, message);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			if(isTrue == true ) {
				 
				 out.println("<script type='text/javascript'>");
					out.println("alert('Message sent Success!!');");
					out.println("location='getMsg'");
					out.println("</script>");
				}else {
					out.println("<script type='text/javascript'>");
					out.println("alert(' unsuccess !!');");
					out.println("location='getMsg'");
					out.println("</script>");
				}
			
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert(' unsuccess !!');");
			out.println("location='Contactus.jsp'");
			out.println("</script>");
		}
	}

}
