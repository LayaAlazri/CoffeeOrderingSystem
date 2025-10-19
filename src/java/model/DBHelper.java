/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBHelper {

    private static final String URL = "jdbc:mariadb://localhost:3306/coffee_orders";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void saveOrder(String customerName, String coffeeItems, double totalPrice) {
        String sql = "INSERT INTO orders (customer_name, coffee_items, total_price, order_time) VALUES (?, ?, ?, NOW())";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customerName);
            stmt.setString(2, coffeeItems);
            stmt.setDouble(3, totalPrice);
            stmt.executeUpdate();

            System.out.println("Order saved successfully to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

