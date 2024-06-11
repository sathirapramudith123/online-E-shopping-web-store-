<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Luxuriya</title>
        <link rel="stylesheet" href="./review.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'
            crossorigin='anonymous'></script>

        <link rel="stylesheet" href="./Style/contactusupdate.css">

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
                <li><a href="./Myaccount.jsp">MYACCOUNT</a></li>
                <li><a href="log-out">LOGOUT</a></li>
            </ul>
        </div>

        <form>
            <section>
                <div>
                    <h1>
                        Contact Us
                    </h1>
                </div>
                <div>
                    <div>
                        <p> Name </p>
                        <input type="text" name="id" size="30px" maxlength="20"
                            autocomplete="off" required>
                    </div>
                    <div>
                        <p> Email </p>
                        <input type="email" name="email" size="30px"
                            maxlength="50" autocomplete="off" required>
                    </div>
                    <div>
                        <p> Message </p>
                        <textarea>

                    </textarea>
                    </div>
                    <div>
                        <input type="submit" value="Change">
                    </div>
                </div>
            </section>
        </form>

        <footer>
            <div class="container4">
                <a href="#" class="link">About us</a>
                <a href="./Contactus.jsp" class="link">Contact us</a>
                <a href="#" class="link">Privacy Policy</a>
                <a href="#" class="link">Terms & Condition</a>

            </div>

        </footer>

    </body>
</html>>
</html>