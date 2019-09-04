package service;

import model.OrderItem;

public interface OrderItemService {

    void create(OrderItem orderItem);

    OrderItem get(Integer id);

    void update(OrderItem orderItem);
}
