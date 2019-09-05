package dao.impl;

import dao.OrderDAO;
import model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext(unitName = "shop")
    private EntityManager em;

    @Override
    @Transactional
    public void save(Order order) {
        em.persist(order);
    }

    @Override
    @Transactional
    public void update(Order order) {
        em.merge(order);
    }

    @Override
    public List<Order> getAll() {
        return em.createNamedQuery(Order.ALL_SORTED, Order.class).getResultList();
    }

    @Override
    public Order get(Integer id) {
        return em.find(Order.class, id);
    }

}
