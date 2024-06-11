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
import LxDao.clothingDao;
import LxModel.clothing;

/**
 * Servlet implementation class DeleteProductServelet
 */
@WebServlet("/delete-product")
public class DeleteProductServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String cid = request.getParameter("prid");
		
		clothingDao cm = new clothingDao(DbCon.getConnection());
		boolean isTrue = cm.deleteProduct(cid);
		
		if(isTrue == true) {
			
			    out.println("<script type='text/javascript'>");
				out.println("alert('Item Delete  Successfully !!');");
				out.println("location = 'Delete.jsp'");
				out.println("</script>");
		}else {
			List<clothing> cDetails = cm.getClothingDetails(cid);
			request.setAttribute("cDetails", cDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("");
			dispatcher.forward(request, response);
			
		}
	}

}
