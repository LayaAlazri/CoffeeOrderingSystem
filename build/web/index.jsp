<%-- 
    Document   : index
    Created on : Oct 10, 2025, 11:55:56 PM
    Author     : 96895
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Coffee Order</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Place Your Coffee Order</h1>

    <!-- user name -->
    <div class="name-input">
        <label for="name">Your Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter your name" required>
    </div>

    <div class="coffee-menu">
        <!-- coffee items -->
        <div class="coffee-item" data-name="Espresso" data-price="1.2">
            <img src="images/espresso.jpg" alt="Espresso">
            <h3>Espresso</h3>
            <p>1.2 O.R</p>
            <button onclick="addToCart('Espresso', 1.2)">Add to Cart</button>
        </div>
        <div class="coffee-item" data-name="Latte" data-price="1.8">
            <img src="images/latte.jpg" alt="Latte">
            <h3>Latte</h3>
            <p>1.8 O.R</p>
            <button onclick="addToCart('Latte', 1.8)">Add to Cart</button>
        </div>
        <div class="coffee-item">
                <img src="images/cappuccino.jpg" alt="Cappuccino">
                <h3>Cappuccino</h3>
                <p>1.8 O.R</p>
                <button onclick="addToCart('Cappuccino', 1.8)">Add to Cart</button>
            </div>
            <div class="coffee-item">
                <img src="images/americano.jpg" alt="Americano">
                <h3>Americano</h3>
                <p>1.0 O.R</p>
                <button onclick="addToCart('Americano', 1.0)">Add to Cart</button>
            </div>
            <div class="coffee-item">
                <img src="images/mocha.jpg" alt="Mocha">
                <h3>Mocha</h3>
                <p>1.9 O.R</p>
                <button onclick="addToCart('Mocha', 1.9)">Add to Cart</button>
            </div>
            <div class="coffee-item">
                <img src="images/v60.jpg" alt="v60">
                <h3>V60</h3>
                <p>2.1 O.R</p>
                <button onclick="addToCart('V60', 2.1)">Add to Cart</button>
            </div>
            <div class="coffee-item">
                <img src="images/arabic.jpg" alt="arabic">
                <h3>Arabic Coffee</h3>
                <p>2.5 O.R</p>
                <button onclick="addToCart('Arabic Coffee', 2.5)">Add to Cart</button>
            </div>
            <div class="coffee-item">
                <img src="images/matcha.jpg" alt="matcha">
                <h3>Matcha</h3>
                <p>2.0 O.R</p>
                <button onclick="addToCart('Matcha', 2.0)">Add to Cart</button>
            </div>
    </div>
    
    <br>
    <br>

    <!-- cart -->
    <div class="cart">
        <h2>Your Cart</h2>
        <ul id="cart"></ul>
        <p>Total: <span id="total">0</span> O.R</p>

        <form id="orderForm" action="order" method="post">
            <input type="hidden" name="name" id="formName">
            <div id="formCoffees"></div>
            <button type="submit" id="submit-order">Submit Order</button>
        </form>
    </div>
</div>

<script>
let cartItems = [];
let total = 0;

function addToCart(name, price){
    cartItems.push({name, price});
    total += price;
    renderCart();
}

function renderCart(){
    const cart = document.getElementById("cart");
    cart.innerHTML = "";
    cartItems.forEach((item, index) => {
        const li = document.createElement("li");
        li.textContent = item.name + " - " + item.price + " O.R";
        cart.appendChild(li);
    });
    document.getElementById("total").textContent = total.toFixed(2);

    const coffeesDiv = document.getElementById("formCoffees");
    coffeesDiv.innerHTML = "";
    cartItems.forEach(item => {
        const input = document.createElement("input");
        input.type = "hidden";
        input.name = "coffee";
        input.value = item.name;
        coffeesDiv.appendChild(input);
    });

}

document.getElementById("orderForm").addEventListener("submit", function(e){
    document.getElementById("formName").value = document.getElementById("name").value.trim();
});
</script>
</body>
</html>
