package dao.impl;

import dao.ItemDAO;
import model.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ItemDAOImpl implements ItemDAO {

    @PersistenceContext(unitName = "shop")
    private EntityManager em;

    @Override
    public List<Item> getAll() {
        return em.createNamedQuery(Item.ALL_SORTED, Item.class).getResultList();
    }

    @Override
    public Integer getWarehouseBalance(Integer id) {
        return em.createNamedQuery(Item.GET_BALANCE, Integer.class).setParameter(1, id).getResultList().get(0);
    }
}
