package LxServelet;

import java.io.IOException;
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
 * Servlet implementation class ViewProductServelet
 */
@WebServlet("/view-product")
public class ViewProductServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("search");
		
		try {
			clothingDao cdo = new clothingDao(DbCon.getConnection()); 
			List<clothing> cDetails = cdo.validate(name);
			request.setAttribute("cDetails", cDetails);
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("ProductDashBoard.jsp");
		dis.forward(request, response);
		
	}

}
