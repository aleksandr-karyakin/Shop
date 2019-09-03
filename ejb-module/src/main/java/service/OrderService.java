package service;

import model.Order;

import java.util.List;

public interface OrderService {

    void create(Order order);

    void update(Order order);

    List<Order> getAll();
}
