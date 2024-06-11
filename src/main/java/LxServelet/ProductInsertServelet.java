package LxServelet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LxCon.DbCon;
import LxDao.clothingDao;

/**
 * Servlet implementation class ProductInsertServelet
 */
@WebServlet("/product-insert")
public class ProductInsertServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("product_name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String image = request.getParameter("image");
		String Status = request.getParameter("status");
		int Cquantity = Integer.parseInt(request.getParameter("Cquantity"));
		
		
		
		clothingDao cdo = new clothingDao(DbCon.getConnection()); 
		boolean isTrue = cdo.insertProduct(name, category, price, image, Status, Cquantity);
		
		if(isTrue == true) {
			 out.println("<script type='text/javascript'>");
				out.println("alert('Product add Successfully !!');");
				out.println("location = 'addProduct.jsp' ");
				out.println("</script>");
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Product add Unsuccessful !!');");
			out.println("location = 'addProduct.jsp' ");
			out.println("</script>");
		}
		
		
		
	}

}
