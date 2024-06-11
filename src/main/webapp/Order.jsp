<%@page import="LxCon.DbCon" %>
<%@page import="LxModel.*" %>
<%@page import="java.util.*" %>
<%@page import="LxDao.*" %>
<%@ page import="java.text.DecimalFormat" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
DecimalFormat df = new DecimalFormat("#.##");
request.setAttribute("df", df);

User abcd = (User)request.getSession().getAttribute("abcd");
List<Order> orders = null;
if (abcd != null) {
    request.setAttribute("person", abcd);
    orderDao odao  = new orderDao(DbCon.getConnection());
	orders = odao.userOrders(abcd.getuid());
}else{
	response.sendRedirect("login.jsp");
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if(cart_list != null){
	request.setAttribute("cart_list", cart_list);
	
}

%>
    

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Luxuriya</title>
        <link rel = "stylesheet" href= "./Style/Order.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    </head>

<body>
    <div class="topbar">
        <img  class="image" src="./image/logo.jpg">
        <div class="title">Luxuriya</div>
        <ul>
          <li><a href="./Clothing.jsp">CLOTHES</a></li>
          <li><a href="./Cart.jsp">CART <span class="badge badge-danger">${cart_list.size()}</span></a></li>
          <li><a href="./Order.jsp]">ORDER</a></li>
           <li><a href="getReviews">REVIEW</a></li>
          <li><a href="#">MYACCOUNT</a></li>
           <li><a href="log-out">LOGOUT</a></li>
        </ul>
      </div>
      
       <div class="container">
        <div class="card-header">All Orders</div>

        <table class="table table-light">

          <thead>
            <tr>
              <th scope="col">Date</th>
              <th scope="col">Name</th>
              <th scope="col">Category</th>
              <th scope="col">Quantity</th>
              <th scope="col">Price</th>
			  <th scope="col">Cancel</th>
			   <th scope="col">Confirm</th>
            </tr>
          </thead>

          <tbody>
          <%
          if(orders != null){
        	  for(Order o:orders){%>
        	  
        	     <tr>
        	      <td><%=o.getoDate() %></td>
        	      <td><%=o.getName() %></td>
			      <td><%=o.getCategory() %></td>
			      <td><%=o.getoQuantity() %></td>
			      <td><%=df.format(o.getPrice()) %></td>
			      <td><a class="btn" href="cancel-order?cid=<%=o.getOid() %>">Cancel Order</a></td>
			      <td><a class = "btn" href="./Payement.jsp">Confirm Order</a></td>
			
            </tr>
        		  
        		  
        		  
        	  <% }
        	  
        	  
        	  
          }
          
          
          
          
          %>


          </tbody>



        </table>

      </div>
    
      
    





</body>
