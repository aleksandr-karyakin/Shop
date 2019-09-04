package dao;

import model.OrderItem;

public interface OrderItemDAO {

    void save(OrderItem orderItem);

    OrderItem get(Integer id);

    void update(OrderItem orderItem);
}
