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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
@RequestScoped
public class OrderController {

    private Set<Item> selectedItems = new HashSet<>();
    private List<String> itemsNames = new ArrayList<>();

    @EJB
    private OrderService orderService;
    @EJB
    private ItemService itemService;
    @EJB
    private OrderItemService orderItemService;

    @PostConstruct
    public void init() {
        for (Item item : itemService.getAll()) {
            itemsNames.add(item.getName());
        }
    }

    public Set<Item> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(Set<Item> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<String> getItemsNames() {
        return itemsNames;
    }

    public void setItemsNames(List<String> itemsNames) {
        this.itemsNames = itemsNames;
    }

    public List<Order> getOrderList() {
        return orderService.getAll();
    }

    public void createOrder() {
        Order order = new Order();
        order.setDate(LocalDate.now());
        orderService.create(order);
        for (Item item : selectedItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            order.addOrderItem(orderItem);
            orderItemService.create(orderItem);
        }
        order.setOrderStatus(OrderStatus.NEW);
        orderService.update(order);
    }

}
