<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Luxuriya</title>
        <link rel="stylesheet" href="./Style/review.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'
            crossorigin='anonymous'></script>
    </head>
    <body>

        <div class="topbar">
            <img class="image" src="./image/logo.jpg">
            <div class="title">Luxuriya</div>
            <ul>
                <li><a href="./Clothing.jsp">CLOTHES</a></li>
                <li><a href="./Cart.jsp">CART <span
                            class="badge badge-danger">${cart_list.size()}</span></a></li>
                <li><a href="Order.jsp">ORDER</a></li>
                <li><a href="#">MYACCOUNT</a></li>
                <li><a href="log-out">LOGOUT</a></li>
            </ul>
        </div>
        
        

        <div class="review-container">
        
        <%
        	String id = request.getParameter("id");
            String name = request.getParameter("Name");
            String Email = request.getParameter("Email");
            String Rating = request.getParameter("Rating");
            String review = request.getParameter("review");
            
        %>
        
        

            <div class="review-content">
                <div class="review-form">
                    <form action="updateReview" method="post">
                        <div class="review-title"> <center>Edit Review
                            </center></div>
                            
                            <input type="hidden" name="rid" value="<%= id%>">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" id="name" name="name" value="<%=name %>" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email" value="<%=Email %>"
                                required>
                        </div>
                        <div class="form-group">
                            <label for="rating">Rating:</label>
                            <select id="rating" name="rating" value="<%=Rating %>" required>

                                <option value="5">5 stars</option>
                                <option value="4">4 stars</option>
                                <option value="3">3 stars</option>
                                <option value="2">2 stars</option>
                                <option value="1">1 star</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="review">Review:</label>
                            <textarea id="review" name="review" 
                                required><%=review %></textarea>
                        </div>
                        <div class="form-group">
                            <button type="submit">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
         

       

        <footer>
            <div class="container4">
                <a href="#" class="link">About us</a>
                <a href="#" class="link">Contact us</a>
                <a href="#" class="link">Privacy Policy</a>
                <a href="#" class="link">Terms & Condition</a>

            </div>

        </footer>

    </body>
</html>