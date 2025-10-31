package model;

import model.Coffee;
import model.Order;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CoffeeOrderTest {

    //Single item
    @Test
    public void testSingleItemEspresso() {
        Coffee espresso = new Coffee("Espresso", 1.2);
        Order order = new Order("Liya", List.of(espresso));

        assertEquals(1, order.getCoffees().size());
        assertEquals(1.2, order.calculateOriginalTotal(), 0.001);
        assertFalse(order.hasDiscount());
        assertEquals(1.2, order.calculateFinalTotal(), 0.001);
    }

    @Test
    public void testSingleItemLatte() {
        Coffee latte = new Coffee("Latte", 1.8);
        Order order = new Order("Ahmed", List.of(latte));

        assertEquals(1, order.getCoffees().size());
        assertEquals(1.8, order.calculateOriginalTotal(), 0.001);
        assertFalse(order.hasDiscount());
        assertEquals(1.8, order.calculateFinalTotal(), 0.001);
    }

    @Test
    public void testSingleItemAmericano() {
        Coffee americano = new Coffee("Americano", 1.0);
        Order order = new Order("Sara", List.of(americano));

        assertEquals(1, order.getCoffees().size());
        assertEquals(1.0, order.calculateOriginalTotal(), 0.001);
        assertFalse(order.hasDiscount());
        assertEquals(1.0, order.calculateFinalTotal(), 0.001);
    }

    //Multiple item
    @Test
    public void testMultipleItems1() {
        Order order = new Order("Omar", List.of(
                new Coffee("Latte", 1.8),
                new Coffee("Mocha", 1.9),
                new Coffee("V60", 2.1)
        )); // total 5.8

        assertEquals(3, order.getCoffees().size());
        assertEquals(5.8, order.calculateOriginalTotal(), 0.001);
        assertFalse(order.hasDiscount());
        assertEquals(5.8, order.calculateFinalTotal(), 0.001);
    }

    @Test
    public void testMultipleItems2() {
        Order order = new Order("Fatma", List.of(
                new Coffee("Espresso", 1.2),
                new Coffee("Cappuccino", 1.8),
                new Coffee("Latte", 1.8)
        )); // total 4.8

        assertEquals(3, order.getCoffees().size());
        assertEquals(4.8, order.calculateOriginalTotal(), 0.001);
        assertFalse(order.hasDiscount());
        assertEquals(4.8, order.calculateFinalTotal(), 0.001);
    }

    @Test
    public void testMultipleItems3() {
        Order order = new Order("Youssef", List.of(
                new Coffee("Matcha", 2.0),
                new Coffee("V60", 2.1),
                new Coffee("Americano", 1.0)
        )); // total 5.1

        assertEquals(3, order.getCoffees().size());
        assertEquals(5.1, order.calculateOriginalTotal(), 0.001);
        assertFalse(order.hasDiscount());
        assertEquals(5.1, order.calculateFinalTotal(), 0.001);
    }

    //Discount test
    @Test
    public void testDiscount1() {
        Order order = new Order("Sara", List.of(
                new Coffee("Latte", 1.8),
                new Coffee("Mocha", 1.9),
                new Coffee("V60", 2.1),
                new Coffee("Arabic Coffee", 2.5)
        )); // total 8.3

        assertEquals(4, order.getCoffees().size());
        assertEquals(8.3, order.calculateOriginalTotal(), 0.001);
        assertTrue(order.hasDiscount());
        assertEquals(0.415, order.getDiscountAmount(), 0.001);
        assertEquals(7.885, order.calculateFinalTotal(), 0.001);
    }

    @Test
    public void testDiscount2() {
        Order order = new Order("Liya", List.of(
                new Coffee("V60", 2.1),
                new Coffee("Arabic Coffee", 2.5),
                new Coffee("Matcha", 2.0),
                new Coffee("Mocha", 1.9)
        )); // total 8.5

        assertEquals(4, order.getCoffees().size());
        assertEquals(8.5, order.calculateOriginalTotal(), 0.001);
        assertTrue(order.hasDiscount());
        assertEquals(0.425, order.getDiscountAmount(), 0.001);
        assertEquals(8.075, order.calculateFinalTotal(), 0.001);
    }

    @Test
    public void testDiscount3() {
        Order order = new Order("Omar", List.of(
                new Coffee("Arabic Coffee", 2.5),
                new Coffee("Mocha", 1.9),
                new Coffee("V60", 2.1),
                new Coffee("Latte", 1.8)
        )); // total 8.3

        assertEquals(4, order.getCoffees().size());
        assertEquals(8.3, order.calculateOriginalTotal(), 0.001);
        assertTrue(order.hasDiscount());
        assertEquals(0.415, order.getDiscountAmount(), 0.001);
        assertEquals(7.885, order.calculateFinalTotal(), 0.001);
    }
}
