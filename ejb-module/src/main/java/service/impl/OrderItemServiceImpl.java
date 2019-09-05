package service.impl;

import dao.OrderItemDAO;
import model.OrderItem;
import service.OrderItemService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class OrderItemServiceImpl implements OrderItemService {

    @EJB
    private OrderItemDAO orderItemDAO;

    @Override
    @Transactional
    public void create(OrderItem orderItem) {
        orderItemDAO.save(orderItem);
    }

    @Override
    public OrderItem get(Integer id) {
        return orderItemDAO.get(id);
    }

    @Override
    @Transactional
    public void update(OrderItem orderItem) {
        orderItemDAO.update(orderItem);
    }
}
