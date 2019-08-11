package services;

import database.OrderDB;
import models.Order;
import java.util.List;

public class OrderService {

    private OrderDB orderDB;

    public OrderService() {
        orderDB = new OrderDB();
    }

    public Order get(Integer orderNumber) throws Exception {
        return orderDB.getOrder(orderNumber);
    }

    public List<Order> getAllOrders() throws Exception {
        return orderDB.getAll();
    }

    public int update(Integer orderNumber) throws Exception {
        Order order = get(orderNumber);
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
