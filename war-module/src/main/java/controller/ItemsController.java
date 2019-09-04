package controller;

import model.Item;
import service.ItemService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ItemsController {

    @EJB
    private ItemService itemService;

    public List<Item> getItemList() {
        return itemService.getAll();
    }

    public Integer getBalance(Integer id) {
        return itemService.getBalance(id);
    }
}
