package LxServelet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LxCon.DbCon;
import LxDao.clothingDao;
import LxModel.clothing;

/**
 * Servlet implementation class updateProductServelet
 */
@WebServlet("/update-product")
public class updateProductServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String  cid =request.getParameter("prid");
		String name = request.getParameter("pname");
		String category = request.getParameter("pcategory");
		String price = request.getParameter("pprice");
		String image = request.getParameter("pimage");
		String Status = request.getParameter("pstatus");
		String Cquantity =request.getParameter("pquantity");
		
		clothingDao cod = new clothingDao(DbCon.getConnection());
		boolean isTrue = cod.updateProduct(cid, name, category, price, image, Status, Cquantity);
		
		if(isTrue == true) {
			List<clothing> cDetails = cod.getClothingDetails(cid);
			request.setAttribute("cDetails", cDetails);
			
			
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Product Update Successfully !!');");
			out.println("location = 'updateProduct.jsp' ");
			out.println("</script>");
			
		}else {
			
			List<clothing> cDetails = cod.getClothingDetails(cid);
			request.setAttribute("cDetails", cDetails);
			
			
			out.println("<script type='text/javascript'>");
			out.println("alert('Product Update Unsuccessful !!');");
			out.println("location = 'updateProduct.jsp' ");
			out.println("</script>");
			
		}
		
	}

}
