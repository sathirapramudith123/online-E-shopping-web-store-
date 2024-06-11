<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete User</title>
<link rel="stylesheet" href="./Style/Order.css">
<style>
    .btn{
    margin-left: 50%;
    margin-top:20px;
    cursor: pointer;
    }
</style>
</head>
<body>

    <div class="topbar">
        <img  class="image" src="./image/logo.jpg">
        <div class="title">Luxuriya</div>
        <ul>
          <li><a href="./addProduct.jsp">Insert</a></li>
          <li><a href="./viewProduct.jsp">View</a></li>
          <li><a href="./updateProduct.jsp">Update</a></li>
          <li><a href="#">Delete</a></li>
           <li><a href="log-out">LOGOUT</a></li>

        </ul>
      </div>

      <div class="container">
        <div class="card-header">Delete DashBoard</div>
        
         <%
    String  cid =request.getParameter("cid");
	String name = request.getParameter("name");
	String category = request.getParameter("category");
	String price = request.getParameter("price");
	String image = request.getParameter("image");
	String Status = request.getParameter("status");
	String Cquantity = request.getParameter("Cquantity");
    
    %>

        <form action="delete-product" method="post">

            <table class="table table-light">

                <thead>
                    <tr>
                      <th scope="col">Cloth ID</th>
                      <th scope="col">Name</th>
                      <th scope="col">Category</th>
                      <th scope="col">Price</th>
                      <th scope="col">Image</th>
                      <th scope="col">Status</th>
                      <th scope="col">Quantity</th>
                      
                    </tr>
                  </thead>
    
                  <tbody>
                    <tr>
    
                        
               <td><input type="text" name="prid" value="<%=cid %>"></td>
                <td><input type="text" name="pname" value="<%=name %>"></td>
                <td><input type="text" name="pcategory" value="<%=category %>"></td>
                <td><input type="text" name="pprice" value="<%=price %>"></td>
                <td><input type="text" name="pimage" value="<%=image %>"></td>
                <td><input type="text" name="pstatus" value="<%=Status %>"></td>
                 <td><input type="text" name="pquantity" value="<%=Cquantity %>"></td>
               
    
    
                    </tr>
    
    
                </tbody>
            </table>
            
           <button type="submit" class="btn">Delete</button>


        </form>

        
      </div>

      





</body>
</html>