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
}
