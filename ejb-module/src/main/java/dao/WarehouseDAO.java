package dao;

import model.WarehouseItem;

public interface WarehouseDAO {

    WarehouseItem get(Integer id);

    void update(WarehouseItem warehouseItem);
}
