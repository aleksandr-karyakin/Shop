package service.impl;

import dao.OrderDAO;
import model.Order;
import model.OrderItem;
import service.OrderService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class OrderServiceImpl implements OrderService {

    @EJB
    private OrderDAO orderDAO;

    @Override
    public void create(Order order) {
        orderDAO.save(order);
    }

    @Override
    public void update(Order order) {
        orderDAO.update(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    @Override
    public Order get(Integer id) {
        return orderDAO.get(id);
    }
}
