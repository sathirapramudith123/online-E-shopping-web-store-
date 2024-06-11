package LxContact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteContact")
public class deleteContactusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String id = request.getParameter("id");
				
				
				boolean isTrue = false ;
				
				isTrue = ContactUsDBUtil.DeleteContact(id);
				
				if(isTrue == true) {
					
					out.println("<script type='text/javascript'>");
					out.println("alert('Deleted successfully !!');");
					out.println("location='getMsg'");
					out.println("</script>");
					
				}else {
					out.println("<script type='text/javascript'>");
					out.println("alert('Failed');");
					out.println("location='getMsg'");
					out.println("</script>");
					
				} 
	}

}
