package LxServelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LxCon.DbCon;
import LxDao.orderDao;

/**
 * Servlet implementation class CancellOrderServelet
 */
@WebServlet("/cancel-order")
public class CancellOrderServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			String id = request.getParameter("cid");
		
			if(id != null) {
				orderDao od = new orderDao(DbCon.getConnection());
				od.canceOrder(Integer.parseInt(id));
			}
			
			response.sendRedirect("Order.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
