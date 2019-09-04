package service;

import model.Item;

import javax.ejb.Local;
import java.util.List;

public interface ItemService {

    List<Item> getAll();

    Integer getBalance(Integer id);
}
