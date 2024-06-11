<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <%@page import="LxCon.DbCon"%>
<%@page import="LxReview.ReviewDAOimplementaion"%>

<%@page import="java.util.List"%>
<%@page import="LxReview.Review"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Luxuriya</title>
<link rel = "stylesheet" href= "./Style/Home.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
  <div class="topbar">
    <img  class="image" src="./image/logo.jpg">
    <div class="title">Luxuriya</div>
    <ul>
      <li><a href="#">HOME</a></li>
      <li><a href="#">CART</a></li>
      <li><a href="./Clothing.jsp">CLOTHES</a></li>
      <li><a href="#">ACCOUNT</a></li>
      
    </ul>
  </div>

  <div class="section">
    <div class="container">
      <div class="text-wrapper"><span class="text1">Welcome in</span> <span class="text2">Luxuriya Clothing Center</span></div>
      <div class="button">
        <div class ="secondary"><div class = "title2"><a href ="./register.jsp">Register</a></div></div>
        <div class="primary"><div class = "title3"><a href="./login.jsp">LogIN</a></div></div>
        </div>
    </div>
  </div>

  <div class="section2">
    <div class="container2">
      <div class="title4">Featured Products</div>
      <button class="primary-wrapper">
        <div class="title-wrapper"><div class="title5"><a href="./login.jsp">View All Products</a></div></div>
      </button>
    </div>
    <div class="slideshow">
      <div class = "myslides">
         <img   src="./image/frock.jpg" >
         <img   src="./image/pants.jpg" >
         <img   src="./image/shirt.jpg" >
         <img src="./image/shirt2.jpg">
         <img src="./image/shirt3.jpg">
         <img src="./image/short frock.jpg">
         <img src="./image/shirt3.jpg">
         <img src="./image/flower frock.jpg">

      </div>

     </div>
     

   </div>
   
         <center><h2 class="main-review">Our Reviews</h2></center>
      <div class="ourReviews">
      
      <%  
      ReviewDAOimplementaion dao = new ReviewDAOimplementaion(DbCon.getConnection());
	List<Review> list = dao.getAllEvents();
	for(Review p:list){
	%>

        <div class="conainer">
          <div class="review">
            <div class="photo"><img src="./image/user.png"></div>
            <div class="name"><%= p.getName() %></div>
            <div class="rating">
            	<c:forEach begin="1" end="<%= p.getRating() %>">
                <img src="./image/star.png" alt="Full Star" id="starpng">
                
            </c:forEach>
            
            </div>
            <div class="review-dis"><%= p.getReview() %></div>

          </div>
        </div>
        
         <% 
	}
		
	
	%>
        

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