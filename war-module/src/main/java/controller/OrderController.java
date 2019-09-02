package controller;

import model.*;
import service.OrderService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
@RequestScoped
public class OrderController {

    private Set<OrderItem> selectedItems = new HashSet<>();

    @EJB
    private OrderService orderService;

    public List<Order> getOrderList() {
        return orderService.getAll();
    }

    public void createOrder() {
        Order order = new Order();
        order.setDate(LocalDate.now());
        order.setOrderStatus(OrderStatus.NEW);
        for (OrderItem orderItem : selectedItems) {
            order.addOrderItem(orderItem);
        }
        orderService.create(order);
    }

    public void addItem(Item item) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        selectedItems.add(orderItem);
    }
}
