package service.impl;

import dao.OrderDAO;
import model.Order;
import service.OrderService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
    public List<Order> getAll() {
        return orderDAO.getAll();
    }
}
