package org.homework.itemshop.service;

import org.homework.itemshop.config.DBManager;
import org.homework.itemshop.entity.ItemShop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbServiceImpl implements DbService {

    private DBManager dbManager = new DBManager();

    @Override
    public List<ItemShop> getAllItem() throws SQLException, ClassNotFoundException {
        List<ItemShop> itemList = new ArrayList<>();
        dbManager.getAllItem();

        return itemList;
    }

    @Override
    public void deleteItem(Integer id) {
        dbManager.deleteItem(id);
    }

    @Override
    public void addItem(ItemShop item) {
        dbManager.createItem(item);
    }
}
