package services;

import database.OrderDB;
import database.PizzaDB;
import models.Order;
import models.Pizza;
import java.util.List;

public class OrderService {

    private OrderDB orderDB;
    private PizzaDB pizzaDB;

    public OrderService() {
        orderDB = new OrderDB();
        pizzaDB = new PizzaDB();
    }

    public Order getOrder(Integer orderNumber) throws Exception {
        return orderDB.getOrder(orderNumber);
    }

    public List<Order> getAllOrders() throws Exception {
        return orderDB.getAll();
    }

    public Pizza getPizza(Integer pizzaNumber) throws Exception {
        return pizzaDB.getPizza(pizzaNumber);
    }

    public List<Pizza> getAllPizza() throws Exception {
        return pizzaDB.getAll();
    }
    
    public List<Pizza> getAllPizzaFromOrder(Integer orderNumber) throws Exception {
        return pizzaDB.getAllFromOrder(orderNumber);
    }
    
    
    
    
    
    
    
    
    
    
    public int update(Integer orderNumber) throws Exception {
        Order order = getOrder(orderNumber);
        order.setOrderNumber(orderNumber);
        return orderDB.update(order);
    }

    public int delete(Integer orderNumber) throws Exception {
        Order deletedOrder = orderDB.getOrder(orderNumber);
        return orderDB.delete(deletedOrder);
    }

    public int insert(Integer orderNumber, String holder) throws Exception {
        Order order = new Order(orderNumber, holder);
        return orderDB.insert(order);
    }
}
