package dao.impl;

import dao.OrderItemDAO;
import model.OrderItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderItemDAOImpl implements OrderItemDAO {

    @PersistenceContext(unitName = "shop")
    private EntityManager em;

    @Override
    public void save(OrderItem orderItem) {
        em.persist(orderItem);
    }
}
