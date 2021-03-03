package org.homework.itemshop.config;

import org.homework.itemshop.entity.ItemShop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final String QWERY = "Select * From database.ItemShop Where Id = 1";
    private static final String All = "Select * From database.ItemShop";
    private static final String Delete = "DELETE FROM database.ItemShop WHERE Id = ?";
    private static final String Create = "INSERT INTO database.ItemShop  VALUES (NULL,?,?)";


    public void setConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try { Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
            PreparedStatement preparedStatement = connection.prepareStatement(QWERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                ItemShop item = new ItemShop();
                item.setId(resultSet.getLong(1));
                item.setName(resultSet.getString("Name"));
                item.setPrice(resultSet.getDouble("Price"));
                System.out.println(item.toString());
            }
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createItem(ItemShop item){

        try { Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
            PreparedStatement preparedStatement = connection.prepareStatement(Create);
            preparedStatement.setString(1,item.getName());
            preparedStatement.setDouble(2,item.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ItemShop> getAllItem(){
        List<ItemShop> carList = new ArrayList<>();

        try { Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
            PreparedStatement preparedStatement = connection.prepareStatement(All);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                ItemShop item = new ItemShop();
                item.setId(resultSet.getLong(1));
                item.setName(resultSet.getString("Name"));
                item.setPrice(resultSet.getDouble("Price"));
                carList.add(item);
            }
            System.out.println(carList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public void deleteItem(Integer Id){

        try { Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
            PreparedStatement preparedStatement = connection.prepareStatement(Delete);
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
