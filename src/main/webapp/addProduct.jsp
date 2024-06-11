<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Add Product</title>
<link rel="stylesheet" href="./Style/addProdct.css">
</head>
<body>
        <div class="topbar">
            <img  class="image" src="./image/logo.jpg">
            <div class="title">Luxuriya</div>
            <ul>
               <li><a href="#">Insert</a></li>
              <li><a href="./viewProduct.jsp">View</a></li>
              <li><a href="./updateProduct.jsp">Update</a></li>
              <li><a href="./Delete.jsp">Delete</a></li>
               <li><a href="log-out">LOGOUT</a></li>

            </ul>
          </div>

          <div class="container">
            <h1>All Products</h1>

            <form action="product-insert" method="post">

              <div class="form-group">
                <label for="product_name">Product Name:</label>
                <input type="text" id="product_name" name="product_name" required>
              </div>
              
              
              <div class="form-group">
                <label for="price">Product Category:</label>
                <input type="text" id="category" name="category" required>
              </div>

              <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" required>
              </div>
              
                 <div class="form-group">
                <label for="description">Image:</label>
                <textarea id="image" name="image" required></textarea>
              </div>
              
                <div class="form-group">
                <label for="status">Status</label>
                <select name="status" id="status">
                    <option value="stock in">Stock In</option>
                    <option value="sold out">Sold Out</option>
                </select>
              </div>
              
              <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" id="Cquantity" name="Cquantity" required>
              </div>
              
           
               <center> 
               	<input type="submit" name="submit" value="submit" class="btn"> 
               </center>

            </form>

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