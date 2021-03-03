package org.homework.itemshop;

import org.homework.itemshop.entity.ItemShop;
import org.homework.itemshop.service.DbService;
import org.homework.itemshop.service.DbServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class JDBCManager {
    static int choose;
    static Scanner keyboard = new Scanner(System.in);
    private static final DbService service = new DbServiceImpl();
    private static final ItemShop item = new ItemShop();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //DbService service = new DbServiceImpl();


        MainMenu();
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
        /*service.deleteItem(2);
        List<ItemShop> items = service.getAllItem();
        for (ItemShop temp : items) {
            System.out.println(temp.toString());
        }*/
    }


    public static void MainMenu() throws SQLException, ClassNotFoundException {
        System.out.println("Choose one of the following: \n" +
                "PRESS [1] TO ADD ITEMS\n" +
                "PRESS [2] TO LIST ITEMS\n" +
                "PRESS [3] TO DELETE ITEMS\n" +
                "PRESS [0] TO EXIT");
        choose = keyboard.nextInt();

        if (choose == 1) {// 1. Add Item
            Scanner in = new Scanner(System.in);
            System.out.print("Insert name: ");
            String name = in.toString();
            System.getProperty("line.separator");
            double price = in.nextDouble();
            System.out.print("Insert price: ");
            item.setName(name);
            item.setPrice(price);
            service.addItem(item);
            System.out.println("Ur item created successfully");
            MainMenu();
            return;
        }
        if (choose == 2) {// 2. To List Item
            List<ItemShop> items = service.getAllItem();
            for (ItemShop temp : items) {
                System.out.println(temp.toString());
            }
            MainMenu();
            return;
        }
        if (choose == 3) {// 2. To Delete Item
            Scanner in = new Scanner(System.in);
            System.out.print("Insert ID: ");
            int id = in.nextInt();
            service.deleteItem(id);
            System.out.println("Ur item deleted successfully");
            MainMenu();
            return;
        }
        if (choose == 0) {
            System.out.println("You are logged out.");
            System.exit(0);
            if (choose > 3) {
                System.out.println("System ERROR. We  don't have this number operation");
            }
            MainMenu();
        }
    }
}
