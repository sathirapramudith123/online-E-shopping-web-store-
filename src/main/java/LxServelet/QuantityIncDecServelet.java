package LxServelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LxModel.Cart;

/**
 * Servlet implementation class QuantityIncDecServelet
 */
@WebServlet("/quantity-inc-dec")
public class QuantityIncDecServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter();){
			String action = request.getParameter("action");
			int cid = Integer.parseInt(request.getParameter("cid"));
			
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			
			if(action != null && cid > 1) {
				if(action.equals("inc")) {
					for(Cart c:cart_list) {
						if(c.getCid() == cid) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							response.sendRedirect("Cart.jsp");
						}
					}
				}
				
				if(action.equals("dec")) {
					for(Cart c:cart_list) {
						if(c.getCid() == cid && c.getQuantity() > 1) {
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
							break;
						}
					}
					
					response.sendRedirect("Cart.jsp");
				}
					
			}else {
				response.sendRedirect("Cart.jsp");
			}
		}
	}

}
