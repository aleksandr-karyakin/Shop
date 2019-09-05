package dao.impl;

import dao.WarehouseDAO;
import model.WarehouseItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class WarehouseDAOImpl implements WarehouseDAO {

    @PersistenceContext(unitName = "shop")
    private EntityManager em;

    @Override
    public WarehouseItem get(Integer id) {
        return em.find(WarehouseItem.class, id);
    }

    @Override
    @Transactional
    public void update(WarehouseItem warehouseItem) {
        em.merge(warehouseItem);
    }
}
