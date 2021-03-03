package org.homework.itemshop;

import org.homework.itemshop.entity.ItemShop;
import org.homework.itemshop.service.DbService;
import org.homework.itemshop.service.DbServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class JDBCManager {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DbService service = new DbServiceImpl();

        /*ItemShop item = new ItemShop();
        item.setName("Milk");
        item.setPrice(390.2);
        service.addItem(item);
        ItemShop item2 = new ItemShop();
        item2.setName("Chocolate");
        item2.setPrice(540.99);
        service.addItem(item2);*/
        /*ItemShop item3 = new ItemShop();
        item3.setName("Bread");
        item3.setPrice(150.23);
        service.addItem(item3);*/
        /*List<ItemShop> items = service.getAllItem();
        for (ItemShop temp: items) {
            System.out.println(temp.toString());
        }*/
        service.deleteItem(2);
        List<ItemShop> items = service.getAllItem();
        for (ItemShop temp: items) {
            System.out.println(temp.toString());
        }
    }

}
