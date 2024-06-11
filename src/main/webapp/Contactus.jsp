<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Luxuriya</title>
        <link rel="stylesheet" href="./Style/review.css">
        <link rel="stylesheet" href="./Style/contactus.css">
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
                <li><a href="getReviews">REVIEW</a></li>
                <li><a href="./MyAccount.jsp">MYACCOUNT</a></li>
                <li><a href="log-out">LOGOUT</a></li>
            </ul>
        </div>


        <form action="sendMessage" method="post">
        <section>
            <div>
                <h1>
                    Contact Us
                </h1>
                <p>
                    Let's talk on something great together...
                </p>
            </div>
            <div>
                <div>
                    <p> Name </p>
                    <input type="text" name="name" size="30px" maxlength="20" autocomplete="off" required>   
                </div>
                <div>
                    <p> Email </p>
                    <input type="email" name="email" size="30px" maxlength="50" autocomplete="off" required>   
                </div>
                <div>
                    <p> Message </p>
                    <textarea name="message">

                    </textarea>   
                </div>
                <div>
                    <input type="submit" value="Send">
                </div>
            </div>
        </section>
        </form>
         
 		<center><h1 class="titlemassege"> Contact Forms </h1> </center>
        <div class="review-list">
          
            <div class="review-table">
            
            

                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                
                            <th>Message</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                     <c:forEach var="Contact" items="${MsgDetails}">
    
   

    <c:set var = "contactID" value="${Contact.getIdcontactus()}" />
    <c:set var = "userId" value="${Contact.getUserId()}" />
    <c:set var = "Name" value="${Contact.getName()}" />
    <c:set var = "Email" value="${Contact.getEmail()}" />
    <c:set var = "Msg" value="${Contact.getMessage()}" />
    
    

    
  
   
  
                        
                            <tr>
                                <td>${Name}</td>
                                <td>${Email}</td>
                                <td>${Msg}</td>

                                <td><a
                                        href="contactus-edit.jsp?id=${contactID}&Name=${Name}&Email=${Email}&Msg=${Msg}"><button
                                            class="edit">Edit</button></a>
                                    <a
                                        href="deleteContact?id=${contactID}"><button
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
                <a href="./Contactus.jsp" class="link">Contact us</a>
                <a href="#" class="link">Privacy Policy</a>
                <a href="#" class="link">Terms & Condition</a>

            </div>

        </footer>

    </body>
</html>