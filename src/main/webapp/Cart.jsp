<%@page import="LxCon.DbCon"%>
<%@page import="LxModel.*" %>
<%@page import="java.util.*" %>
<%@page import="LxDao.*"%>
<%@ page import="java.text.DecimalFormat" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if(cart_list != null){
	clothingDao cDao = new clothingDao(DbCon.getConnection());
	cartProduct = cDao.getCartProducts(cart_list);
	double total = cDao.getTotalCartPrice(cart_list);
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("total", total);
	
	
}

%>   
   
    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Luxuriya</title>
        <link rel = "stylesheet" href= "./Style/Cart.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    </head>
    <body>
    
        <div class="topbar">
            <img  class="image" src="./image/logo.jpg">
            <div class="title">Luxuriya</div>
            <ul>
              <li><a href="./Clothing.jsp">CLOTHES</a></li>
              <li><a href="./Cart.jsp">CART <span class="badge badge-danger">${cart_list.size()}</span> </a></li>
              <li><a href="./Order.jsp">ORDER</a></li>
               <li><a href="getReviews">REVIEW</a></li>
              <li><a href="./MyAccount.jsp">MYACC</a></li>
              <li><a href="log-out">LOGOUT</a></li>
            </ul>
          </div>

          <div class="price">
           <div class="total-text"> Total Price : Rs. ${(total > 0)?dcf.format(total):0 }.00</div>
            <div class="btn"><a  href="check-out">Check Out</a></div>
          </div>

          <table class="table table light">
            <thead>
                <tr>
                    <th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
                </tr>
            </thead>

            <tbody>
            <%
            if(cart_list != null){
            	for(Cart c:cartProduct){%>
            		<tr>
                    <td><%= c.getName() %></td>
                    <td><%= c.getCategory() %></td>
                    <td><%= dcf.format(c.getPrice()) %></td>

                    <td>
                        <form action="buy-now" method="post" class="form">
                            <input type="hidden" name="id" value="<%= c.getCid() %>" class="form-input">
                            <div class="form-group">
                                <a class="btn1  btn-incre" href="quantity-inc-dec?action=inc&cid=<%=c.getCid()%>"><i class="fa fa-plus-square"></i></a> 
                                <input type="text" name="quantity" class="control" value="<%=c.getQuantity()%>" readonly>
                                <a class="btn1 btn-sm btn-decre" href="quantity-inc-dec?action=dec&cid=<%= c.getCid()%>"><i class="fa fa-minus-square"></i></a>
                            </div>

                            <button type="submit" class="btn1 btn-primary ">Buy</button>

                        </form>
                    </td>

                    <td>
                        <a href="remove-from-cart?cid=<%=c.getCid() %>" class="btn2 btn-secondary">Remove</a></td>

                    </tr>
            		
            	<% }
            }
            %>
                


            </tbody>


          </table>


        
    </body>









</html>