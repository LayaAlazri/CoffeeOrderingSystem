<%-- 
    Document   : bill
    Created on : Oct 10, 2025, 11:56:28 PM
    Author     : 96895
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Order" %>
<%@ page import="model.Coffee" %>
<%
    Order order = (Order) request.getAttribute("order");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Coffee Bill</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <div class="bill-card">
        <h1>Thank You, <%= order.getCustomerName() %>!</h1>
        <h2>Your Order</h2>
        <ul class="bill-list">
            <% for(Coffee c : order.getCoffees()) { %>
                <li><%= c.getName() %> - <%= String.format("%.2f", c.getPrice()) %> O.R</li>
            <% } %>
        </ul>

        <% double originalTotal = order.calculateOriginalTotal(); %>
        <% double discount = order.getDiscountAmount(); %>
        <p class="bill-total">Total: <%= String.format("%.2f", originalTotal) %> O.R</p>

        <% if(discount > 0) { %>
            <p class="bill-discount">Discount (5%): -<%= String.format("%.2f", discount) %> O.R</p>
            <p class="bill-final">Final Total: <%= String.format("%.2f", order.calculateFinalTotal()) %> O.R</p>
        <% } %>

        <a href="index.jsp" class="back-button">Place Another Order</a>
    </div>
</div>
</body>
</html>
