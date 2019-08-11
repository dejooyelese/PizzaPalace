package services;

import database.OrderDB;
import models.Order;
import java.util.List;

public class OrderService {

    private OrderDB orderDB;

    public OrderService() {
        orderDB = new OrderDB();
    }

    public Order get(String orderNumber) throws Exception {
        return orderDB.getOrder(orderNumber);
    }

    public List<Order> getAllOrders() throws Exception {
        return orderDB.getAll();
    }

    public int update(String orderNumber) throws Exception {
        Order order = get(orderNumber);
        order.setOrderNumber(orderNumber);
        return orderDB.update(order);
    }

    public int delete(String orderNumber) throws Exception {
        Order deletedOrder = orderDB.getOrder(orderNumber);
        return orderDB.delete(deletedOrder);
    }

    public int insert(String orderNumber) throws Exception {
        Order order = new Order(orderNumber);
        return orderDB.insert(order);
    }
}
