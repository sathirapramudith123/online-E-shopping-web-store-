<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
           <li><a href="./Home.jsp">HOME</a></li>
          <li><a href="./Clothing.jsp">CLOTHES</a></li>
          <li><a href="./Cart.jsp">CART</a></li>
          <li><a href="./Order.jsp">ORDER</a></li>
          <li><a href="#">MYACCOUNT</a></li>
          <li><a href="log-out">LOGOUT</a></li>

        </ul>
      </div>

      <div class="container">
        <div class="card-header">Delete USer DashBoard</div>
        
        <%
        String uid = request.getParameter("Uid");
		String uName = request.getParameter("Uname");
		String uPassword = request.getParameter("Upass");
		String uAddress = request.getParameter("Uadd");
		String uEmail = request.getParameter("Umail");
		String uPhone = request.getParameter("Uphone");
        
        
        %>
   
        <form action="delete-user" method="post">

            <table class="table table-light">

                <thead>
                    <tr>
                      <th scope="col">UserID</th>
                      <th scope="col">Name</th>
                      <th scope="col">Password</th>
                      <th scope="col">Address</th>
                      <th scope="col">Email</th>
                      <th scope="col">Phone</th>
                      
                    </tr>
                  </thead>
    
                  <tbody>
                    <tr>
    
                        
                <td><input type="text" name="Uid" value="<%=uid %>"></td>
                <td><input type="text" name="Uname" value="<%=uName %>"></td>
                <td><input type="text" name="Upass" value="<%=uPassword %>"></td>
                <td><input type="text" name="Uadd" value="<%=uAddress %>"></td>
                <td><input type="text" name="Umail" value="<%=uEmail %>"></td>
                <td><input type="text" name="Uphone" value="<%=uPhone %>"></td>
               
                    </tr>
    
    
                </tbody>
            </table>
            
           <button type="submit" class="btn">Delete</button>


        </form>

        
      </div>

      





</body>
</html>