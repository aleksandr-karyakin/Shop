package controller;

import model.*;
import service.OrderService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.time.LocalDate;

@Named
@RequestScoped
public class OrderController {

    private static final User TEST_USER = new User("testUser");

    @EJB
    private OrderService orderService;

    public void createOrder(Item item) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setOrderStatus(OrderStatus.NEW);
        order.setUser(TEST_USER);
        order.addOrderItem(orderItem);
    }
}
