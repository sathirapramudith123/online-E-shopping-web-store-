<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       
    
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
          <li><a href="./Cart.jsp">CART</a></li>
          <li><a href="./Order.jsp">ORDER</a></li>
           <li><a href="getReviews">REVIEW</a></li>
          <li><a href="#">MYACC</a></li>
          <li><a href="log-out">LOGOUT</a></li>
        </ul>
      </div>

      <div class="container">
        <div class="card-header">My Account</div>

        <table class="table table-light">
        
        <c:forEach var = "usr" items = "${cus}">
      
        
          <thead>
            <tr>
            
              <th scope="col">UserId</th>
              <th scope="col">UserName</th>
              <th scope="col">Password</th>
              <th scope="col">Address</th>
              <th scope="col">Email</th>
              <th scope="col">Phone</th>
			  <th scope="col">Update</th>
              <th scope="col">Delete</th>

            </tr>
          </thead>

          <tbody>
 
        	  
        	   <tr>
            <td>${usr.uid}</td>
            <td>${usr.uName}</td>
            <td>${usr.uPassword}</td>
            <td>${usr.uAddress}</td>
            <td>${usr.uEmail}</td>
            <td>${usr.uPhone}</td>
            
			
                        
			<td><a class="btn" href="updateUser.jsp">Update</a></td>
            <td><a class="btn" href="DeleteUser.jsp">Delete</a></td>
            
            </tr>
        		
          </tbody>


      </c:forEach>
        </table>








      </div>
    





</body>


</html>