package LxServelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LxCon.DbCon;
import LxDao.*;
import LxModel.*;



/**
 * Servlet implementation class PayementServelet
 */
@WebServlet("/pay")
public class PayementServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String  email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String card = request.getParameter("card");
		String number = request.getParameter("number");
		String exp = request.getParameter("exp");
		int year = Integer.parseInt(request.getParameter("year"));
		int cvv = Integer.parseInt(request.getParameter("cvv"));
		
		System.out.println(name + email + address+ city + country + zip + card + number + exp + year + cvv );
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			
			boolean isTrue = false;
			
			try {
				
				isTrue = PayementDao.addPayement(name, email, address, city, country, zip, card, number, exp, year, cvv);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			if(isTrue == true) {
				
				 out.println("<script type='text/javascript'>");
					out.println("alert('Payement Added !!');");
					out.println("location = 'Order.jsp'");
					out.println("</script>");
				
			}else {
				out.println("<script type='text/javascript'>");
				out.println("alert(' unsuccess !!');");
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
