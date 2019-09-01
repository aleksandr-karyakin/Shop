package service.impl;

import dao.ItemDAO;
import model.Item;
import service.ItemService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ItemServiceImpl implements ItemService {

    @EJB
    private ItemDAO itemDAO;

    @Override
    public List<Item> getAll() {
        return itemDAO.getAll();
    }
}
