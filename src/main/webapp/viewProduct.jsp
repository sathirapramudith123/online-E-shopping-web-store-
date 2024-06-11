

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view prodcut</title>
<link rel="stylesheet" href="./Style/viewProduct.css">
</head>
<body>

    <div class="topbar">
        <img  class="image" src="./image/logo.jpg">
        <div class="title">Luxuriya</div>
        <ul>
          <li><a href="./addProduct.jsp">Insert</a></li>
          <li><a href="./viewProduct.jsp">View</a></li>
          <li><a href="./updateProduct.jsp">Update</a></li>
          <li><a href="./Delete.jsp">Delete</a></li>
           <li><a href="log-out">LOGOUT</a></li>

        </ul>
      </div>
    <div class="view">
        <h2>Product Search</h2>
        <form action="view-product" method="post" class="main">
        <input type="text" id="search" name="search" required>
		<input type="submit" name="submit" value="submit" class="btn">
        </form>
    </div>

    <footer class="footer">
        <div class="container4">
            <a href="#" class="link">About us</a>
            <a href="#" class="link">Contact us</a>
            <a href="#" class="link">Privacy Policy</a>
            <a href="#" class="link">Terms & Condition</a>
    
    
        </div>
    
      
    
    </footer>

</body>
</html>