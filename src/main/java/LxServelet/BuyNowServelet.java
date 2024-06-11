package LxServelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LxCon.DbCon;
import LxDao.*;
import LxModel.*;


/**
 * Servlet implementation class BuyNowServelet
 */
@WebServlet("/buy-now")
public class BuyNowServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
			
			User abcd = (User)request.getSession().getAttribute("abcd");
			
			if(abcd != null) {
				
				String clothId = request.getParameter("id");
				int clothQuantity = Integer.parseInt(request.getParameter("quantity"));
				
				if(clothQuantity <= 0) {
					clothQuantity = 1;
				}
				
				Order om = new Order();
				
				om.setCid(Integer.parseInt(clothId));
				om.setU_id(abcd.getuid());
				om.setoQuantity(clothQuantity);
				om.setoDate(formatter.format(date));
				
				orderDao oDao = new orderDao(DbCon.getConnection());
				boolean result = oDao.insertOrder(om);
				
				if(result) {
					
					ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
					if(cart_list != null) {
						for(Cart c:cart_list) {
							if(c.getCid() == Integer.parseInt(clothId)) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}
							
						}
						
					}
					response.sendRedirect("Order.jsp");
				}else {
					out.print("order failed");
				}
				
				
				
				
				
			}else {
				response.sendRedirect("login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
