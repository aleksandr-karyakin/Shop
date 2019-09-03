package dao.impl;

import dao.OrderDAO;
import model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext(unitName = "shop")
    private EntityManager em;

    @Override
    public void save(Order order) {
        em.persist(order);
    }

    @Override
    public void update(Order order) {
        em.merge(order);
    }

    @Override
    public List<Order> getAll() {
        return em.createNamedQuery(Order.ALL_SORTED, Order.class).getResultList();
    }
}
