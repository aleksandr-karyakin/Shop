package service.impl;

import dao.OrderItemDAO;
import model.OrderItem;
import service.OrderItemService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrderItemServiceImpl implements OrderItemService {

    @EJB
    private OrderItemDAO orderItemDAO;

    @Override
    public void create(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }
}
