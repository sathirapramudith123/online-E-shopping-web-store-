package LxServelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LxCon.DbCon;
import LxDao.*;
import LxModel.*;

/**
 * Servlet implementation class CheckOutservelet
 */
@WebServlet("/check-out")
public class CheckOutservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try(PrintWriter out = response.getWriter()){
		   
		   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           Date date = new Date();
           
           ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
           
           User abcd = (User)request.getSession().getAttribute("abcd");
           
           if(cart_list != null && abcd != null) {
        	   
        	   for(Cart c:cart_list ) {
        		   Order order  = new Order();
        		   order.setCid(c.getCid());
        		   order.setU_id(abcd.getuid());
        		   order.setoQuantity(c.getQuantity());
        		   order.setoDate(formatter.format(date));
        		   
        		   orderDao orDao = new orderDao(DbCon.getConnection());
        		   boolean result = orDao.insertOrder(order);
        		   if(!result) break;
        	   }
        	   
        	   cart_list.clear();
        	   response.sendRedirect("Order.jsp");
        	   
           }else {
        	   if(abcd == null) response.sendRedirect("login.jsp");
        	   response.sendRedirect("Cart.jsp");
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
