package service.impl;

import dao.WarehouseDAO;
import model.WarehouseItem;
import service.WarehouseService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class WarehouseServiceImpl implements WarehouseService {

    @EJB
    private WarehouseDAO warehouseDAO;

    @Override
    public void changeCount(Integer itemId, Integer changeBy) {
        WarehouseItem warehouseItem = warehouseDAO.get(itemId);
        warehouseItem.setCount(warehouseItem.getCount() - changeBy);
        warehouseDAO.update(warehouseItem);
    }
}
