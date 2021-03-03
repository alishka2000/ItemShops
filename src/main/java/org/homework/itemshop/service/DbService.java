package org.homework.itemshop.service;

import org.homework.itemshop.entity.ItemShop;

import java.sql.SQLException;
import java.util.List;

public interface DbService {
    List<ItemShop> getAllItem() throws SQLException, ClassNotFoundException;

    void deleteItem(Integer id);

    void addItem(ItemShop item);
}
