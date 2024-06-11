package LxServelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LxModel.Cart;

/**
 * Servlet implementation class AddtoCartServelet
 */
@WebServlet("/add-to-cart")
public class AddtoCartServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<>();
			
			int cid = Integer.parseInt(request.getParameter("cid"));
			Cart cm = new Cart();
			cm.setCid(cid);
			cm.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
			
			if(cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("Clothing.jsp");
			}else {
				cartList = cart_list;
				boolean exist = false;
				
				for(Cart c:cart_list) {
					if(c.getCid() == cid) {
						exist = true;
						 out.println("<script type='text/javascript'>");
							out.println("alert('Item Already Add . Go to Cart Page !!');");
							out.println("location = 'Cart.jsp'");
							out.println("</script>");
					}
					
				}
				
				if(!exist) {
					cartList.add(cm);
					response.sendRedirect("Clothing.jsp");
				}
			}
			
		}
	}

}
