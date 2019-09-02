package service.impl;

import dao.OrderDAO;
import model.Order;
import service.OrderService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrderServiceImpl implements OrderService {

    @EJB
    private OrderDAO orderDAO;

    @Override
    public void create(Order order) {
        orderDAO.save(order);
    }
}
