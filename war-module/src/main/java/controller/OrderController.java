package controller;

import model.*;
import service.ItemService;
import service.OrderItemService;
import service.OrderService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.*;

@Named
@RequestScoped
public class OrderController {

    private Set<Item> selectedItems = new HashSet<>();

    @EJB
    private OrderService orderService;
    @EJB
    private OrderItemService orderItemService;

    public Set<Item> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(Set<Item> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<Order> getOrderList() {
        return orderService.getAll();
    }

    public Order getOrder(Integer id) {
        return orderService.get(id);
    }

    public OrderItem getOrderItem(Integer id) {
        return orderItemService.get(id);
    }

    public void changeCount(Integer id, Integer count) {
        OrderItem orderItem = getOrderItem(id);
        orderItem.setCount(count);
        orderItemService.update(orderItem);
    }

    public void createOrder() {
        Order order = new Order();
        order.setDate(LocalDate.now());
        orderService.create(order);
        for (Item item : selectedItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setCount(1);
            order.addOrderItem(orderItem);
            orderItemService.create(orderItem);
        }
        order.setOrderStatus(OrderStatus.NEW);
        orderService.update(order);
    }

}
