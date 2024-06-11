<%@page import="LxDao.clothingDao" %>
<%@page import="LxCon.DbCon" %>
<%@page import="LxModel.*" %>
<%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
clothingDao cd = new clothingDao(DbCon.getConnection());
List<clothing> clothings = cd.getAllclothings();

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
 <link rel = "stylesheet" href= "./Style/Category.css">
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
              <li><a href="Order.jsp">ORDER</a></li>
              <li><a href="getReviews">REVIEW</a></li>
              <li><a href="./MyAccount.jsp">MYACCOUNT</a></li>
              <li><a href="log-out">LOGOUT</a></li>
            </ul>
          </div>

          <div class="container">
            <div class="product-card">
            
            <%
            
              if( !clothings.isEmpty()){
            	  for(clothing c : clothings){%>
            		  <div class="card">
                      <img class="card-img-top" src="./image/<%= c.getImage() %>">
                      <div class="card-body">
                          <h5 class="card-title"><%= c.getName() %></h5>
                          <h6 class="price">Price: Rs.<%= c.getPrice() %></h6>
                          <h6 class="category">Category: <%= c.getCategory() %></h6>
                          <div class="button">
                              <a class="btn btn-dark" href="add-to-cart?cid=<%= c.getCid() %>">Add to Cart</a>
                              <a class="btn btn-primary" href="buy-now?quantity=1&id=<%= c.getCid() %>">Buy Now</a>
                          </div>
                      </div>
                  </div>

                 
            	  <%}
              }
            
            %>


          </div>

          </div>
          
   <footer>
    <div class="container4">
        <a href="#" class="link">About us</a>
        <a href="./Contactus.jsp" class="link">Contact us</a>
        <a href="#" class="link">Privacy Policy</a>
        <a href="#" class="link">Terms & Condition</a>


    </div>

</footer>



</body>
</html>