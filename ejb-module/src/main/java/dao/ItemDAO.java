package dao;

import model.Item;

import java.util.List;

public interface ItemDAO {

    List<Item> getAll();

    Integer getWarehouseBalance(Integer id);
}
