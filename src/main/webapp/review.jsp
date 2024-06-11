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
                <li><a href="./MyAccount.jsp">MYACCOUNT</a></li>
                <li><a href="log-out">LOGOUT</a></li>
            </ul>
        </div>
        
        

        <div class="review-container">
        
        

            <div class="review-content">
                <div class="review-form">
                    <form action="addReview" method="post">
                        <div class="review-title"> <center>Add Review
                            </center></div>
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" id="name" name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email"
                                required>
                        </div>
                        <div class="form-group">
                            <label for="rating">Rating:</label>
                            <select id="rating" name="rating" required>

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
                                required></textarea>
                        </div>
                        <div class="form-group">
                            <button type="submit">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
         
 		<center><h1>My reviews</h1> </center>
        <div class="review-list">
          
            <div class="review-table">
            
            

                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Rating</th>
                            <th>Review</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                     <c:forEach var="Rvw" items="${ReviewDetails}">
    
   

    <c:set var = "Reviewid" value="${Rvw.getReviewid()}" />
    <c:set var = "userId" value="${Rvw.getUserId()}" />
    <c:set var = "Name" value="${Rvw.getName()}" />
    <c:set var = "Email" value="${Rvw.getEmail()}" />
    <c:set var = "Rating" value="${Rvw.getRating()}" />
    <c:set var = "Review" value="${Rvw.getReview()}" />
    
    
     <!-- Determine the number of full stars -->
    <c:set var="fullStars" value="${Rating}" />
    <!-- Determine the number of empty stars -->
    <c:set var="emptyStars" value="${5 - Rating}" />
    
  
   
  
                        
                            <tr>
                                <td>${Name}</td>
                                <td>${Email}</td>
                                <td>
                                
                                
                                 <!-- Display full stars -->
            <c:forEach begin="1" end="${fullStars}">
                <img src="./image/star.png" alt="Full Star">
            </c:forEach>
          
                                
                                
                                </td>
                                <td>${Review}</td>

                                <td><a
                                        href="review-edit.jsp?id=${Reviewid}&Name=${Name}&Email=${Email}&Rating=${Rating}&review=${Review}"><button
                                            class="edit">Edit</button></a>
                                    <a
                                        href="deleteReview?id=${Reviewid}"><button
                                            class="delete">Delete</button></a></td>
                            </tr>
                       </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

        <footer>
            <div class="container4">
                <a href="#" class="link">About us</a>
                <a href="#" class="link">Privacy Policy</a>
                <a href="#" class="link">Terms & Condition</a>
                <a href="./Contactus.jsp" class="link">Contact us</a>

            </div>

        </footer>

    </body>
</html>