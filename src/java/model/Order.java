/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

public class Order {
    private String customerName;
    private List<Coffee> coffees;

    public Order(String customerName, List<Coffee> coffees) {
        this.customerName = customerName;
        this.coffees = coffees;
    }

    public String getCustomerName() { return customerName; }
    public List<Coffee> getCoffees() { return coffees; }

    public double calculateTotal() {
        return coffees.stream().mapToDouble(Coffee::getPrice).sum();
    }
}
