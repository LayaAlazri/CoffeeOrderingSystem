/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Coffee;
import model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String customerName = request.getParameter("name");
        
        String[] coffeeNames = request.getParameterValues("coffee"); // multiple coffees

        List<Coffee> coffees = new ArrayList<>();
        for(String name : coffeeNames) {
            switch(name) {
                case "Espresso": coffees.add(new Coffee("Espresso", 1.2)); break;
                case "Latte": coffees.add(new Coffee("Latte", 1.8)); break;
                case "Cappuccino": coffees.add(new Coffee("Cappuccino", 1.8)); break;
                case "Americano": coffees.add(new Coffee("Americano", 1.0)); break;
                case "Mocha": coffees.add(new Coffee("Mocha", 1.9)); break;
                case "V60": coffees.add(new Coffee("V60", 2.1)); break;
                case "Arabic Coffee": coffees.add(new Coffee("Arabic Coffee", 2.5)); break;
                case "Matcha": coffees.add(new Coffee("Matcha", 2.0)); break;
            }
        }

        Order order = new Order(customerName, coffees);
        
        //save the order in database
        StringBuilder coffeeList = new StringBuilder();
        for (Coffee c : coffees) {
            coffeeList.append(c.getName()).append(", ");
        }
        if (coffeeList.length() > 0)
            coffeeList.setLength(coffeeList.length() - 2);

        double totalPrice = order.calculateTotal();
        model.DBHelper.saveOrder(customerName, coffeeList.toString(), totalPrice);
        
        request.setAttribute("order", order);
        request.getRequestDispatcher("bill.jsp").forward(request, response);
    }
}
