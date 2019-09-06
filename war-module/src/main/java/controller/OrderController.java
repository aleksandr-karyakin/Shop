package controller;

import model.*;
import service.ItemService;
import service.OrderItemService;
import service.OrderService;
import service.WarehouseService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
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
    @EJB
    private WarehouseService warehouseService;

    public Set<Item> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(Set<Item> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<Order> getOrderList() {
        return orderService.getAll();
    }

    public String getAddress(Integer id) {
        Order order = getOrder(id);
        if (order instanceof DeliveryOrder) {
            return ((DeliveryOrder) order).getAddress();
        } else return "no address";
    }

    public Integer getPrepayment(Integer id) {
        Order order = getOrder(id);
        if (order instanceof PrepaymentOrder) {
            return ((PrepaymentOrder) order).getPrepayment();
        } else return 0;
    }

    public Order getOrder(Integer id) {
        return orderService.get(id);
    }

    public OrderItem getOrderItem(Integer id) {
        return orderItemService.get(id);
    }

    @Transactional
    public void changeCount(Integer id, Integer count) {
        OrderItem orderItem = getOrderItem(id);
        orderItem.setCount(count);
        orderItemService.update(orderItem);
    }

    public Integer getOrderSum(Integer id) {
        int sum = 0;
        Order order = getOrder(id);
        for (OrderItem orderItem : order.getOrderItems()) {
            sum += orderItem.getCount() * orderItem.getItem().getPrice();
        }
        return sum;
    }

    @Transactional
    public void deleteItemFromOrder(Integer orderId, Integer itemId) {
        Order order = getOrder(orderId);
        OrderItem orderItem = getOrderItem(itemId);
        order.removeOrderItem(orderItem);
        orderService.update(order);
        orderItemService.update(orderItem);
    }

    @Transactional
    public void sendOrder(Integer id) {
        Order order = getOrder(id);
        order.setOrderStatus(OrderStatus.SENDED);
        orderService.update(order);
        for (OrderItem orderItem : order.getOrderItems()) {
            Integer itemId = orderItem.getItem().getId();
            Integer changeBy = orderItem.getCount();
            warehouseService.changeCount(itemId, changeBy);
        };
    }

    @Transactional
    public void createOrder(List<Item> items) {
        Order order = new Order();
        order.setDate(LocalDate.now());
        orderService.create(order);
        for (Item item : items) {
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
