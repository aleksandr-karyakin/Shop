package dao.impl;

import dao.OrderDAO;
import model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext(unitName = "shop")
    private EntityManager em;

    @Override
    public void save(Order order) {
        em.persist(order);
    }
}
