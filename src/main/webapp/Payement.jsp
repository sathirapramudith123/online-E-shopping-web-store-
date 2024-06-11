<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
        
        function alert_on_submit() {
        	
        	alert("Transaction succeed!");
        	}
        
        </script>
        <meta charset="ISO-8859-1">
        <title>Luxuriya</title>
        <link rel = "stylesheet" href= "./Style/Payement.css">
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
          <li><a href="./MyAccount.jsp">ACCOUNT</a></li>
          <li><a href="log-out">LOGOUT</a></li>
        </ul>
      </div>

      
      <div class="container">

        <form action="pay" method="post">
    
            <div class="row">
    
                <div class="col">
    
                    <h3 class="title">billing address</h3>
    
                    <div class="inputBox">
                        <span>full name :</span>
                        <input type="text" name="name" placeholder="Full Name">
                    </div>
                    <div class="inputBox">
                        <span>email :</span>
                        <input type="email" name="email" placeholder="example@example.com">
                    </div>
                    <div class="inputBox">
                        <span>address :</span>
                        <input type="text" name="address" placeholder="room - street - locality">
                    </div>
                    <div class="inputBox">
                        <span>city :</span>
                        <input type="text" name="city" placeholder="City">
                    </div>
    
                    <div class="flex">
                        <div class="inputBox">
                            <span>state :</span>
                            <input type="text" name="country" placeholder="Country">
                        </div>
                        <div class="inputBox">
                            <span>zip code :</span>
                            <input type="text" name="zip" placeholder="123 456">
                        </div>
                    </div>
    
                </div>
    
                <div class="col">
    
                    <h3 class="title">payment</h3>
    
                    <div class="inputBox">
                        <span>cards accepted :</span>
                        <img src="./image/card_img.png" alt="">
                    </div>
                    <div class="inputBox">
                        <span>name on card :</span>
                        <input type="text" name="card" placeholder="mr. name">
                    </div>
                    <div class="inputBox">
                        <span>credit card number :</span>
                        <input type="number" name="number" placeholder="1111-2222-3333-4444">
                    </div>
                    <div class="inputBox">
                        <span>exp month :</span>
                        <input type="text" name="exp" placeholder="january">
                    </div>
    
                    <div class="flex">
                        <div class="inputBox">
                            <span>exp year :</span>
                            <input type="number" name="year"  placeholder="2024">
                        </div>
                        <div class="inputBox">
                            <span>CVV :</span>
                            <input type="text" name="cvv" placeholder="1234">
                        </div>
                    </div>
    
                </div>
        
            </div>
    
            <input type="submit" value="proceed to checkout" class="submit-btn" onsubmit = "alert_on_submit()"/>
           
        </form>
    
    </div>

</body>


</html>