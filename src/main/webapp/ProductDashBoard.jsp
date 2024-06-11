
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductDashBoard</title>
<link rel="stylesheet" href="./Style/Order.css">
</head>
<body>

    
    <div class="topbar">
        <img  class="image" src="./image/logo.jpg">
        <div class="title">Luxuriya</div>
        <ul>
          <li><a href="./addProduct.jsp">Insert</a></li>
          <li><a href="./viewProduct.jsp">View</a></li>
          <li><a href="updateProduct.jsp">Update</a></li>
          <li><a href="./Delete.jsp">Delete</a></li>
           <li><a href="log-out">LOGOUT</a></li>

        </ul>
      </div>

      <div class="container">
        <div class="card-header">Product DashBoard</div>

        <table class="table table-light">
        
        <c:forEach var="dress" items="${cDetails}">

            <thead>
                <tr>
                  <th scope="col">Cloth ID</th>
                  <th scope="col">Name</th>
                  <th scope="col">Category</th>
                  <th scope="col">Price</th>
                  <th scope="col">Image</th>
                  <th scope="col">Status</th>
                  <th scope="col">Update</th>
                  <th scope="col">Delete</th>
                </tr>
              </thead>

              <tbody>
                <tr>

                    
            <td>${dress.cid }</td>
            <td>${dress.name }</td>
            <td>${dress.category }</td>
            <td>${dress.price }</td>
            <td>${dress.image }</td>
            <td>${dress.status }</td>
            <td><a class="btn" href="./updateProduct.jsp">Update</a></td>
            <td><a class="btn" href="./Delete.jsp">Delete</a></td>
            


                </tr>


              </tbody>
              
              </c:forEach>

        </table>




      </div>


  



</body>
</html>