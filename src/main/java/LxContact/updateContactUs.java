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

@WebServlet("/updateContactus")
public class updateContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		int Cid = Integer.parseInt(request.getParameter("Contactid"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String Msg = request.getParameter("Msg");
		
		System.out.println(Cid + name + email + Msg);
		
		
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			Object user = session.getAttribute("abcd");
			User loggedUser = (User) user;
			int uid = loggedUser.getuid();
			System.out.println(uid);
			
			boolean isTrue = false ;
			
			try {
				isTrue = ContactUsDBUtil.updateContactUS(Cid,uid , name, email, Msg);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			if(isTrue == true ) {
				 
				 out.println("<script type='text/javascript'>");
					out.println("alert('Update Successfully !!');");
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
			out.println("location='Home.jsp'");
			out.println("</script>");
		}
	}

}
