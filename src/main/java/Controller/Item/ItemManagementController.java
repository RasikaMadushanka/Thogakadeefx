package Controller.Item;

import Model.dto.ItemInfoDto;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemManagementController implements ItemService {
    public void addItem(String Item_Code, String Description, String Category, int Qty, double UnitPrice) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakadesystem", "root", "20051216");
            String SQL="INSERT INTO item  VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,Item_Code);
            preparedStatement.setObject(2,Description);
            preparedStatement.setObject(3,Category);
            preparedStatement.setObject(4,Qty);
            preparedStatement.setObject(5,UnitPrice);
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteItem(String EmployeeID){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakadesystem", "root", "20051216");
            PreparedStatement pstm =connection.prepareStatement("DELETE FROM item WHERE ItemCode=?");
            pstm.setObject(1,EmployeeID);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateItem(String Item_Code, String Description, String Category, int Qty, double UnitPrice){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakadesystem", "root", "20051216");
            String SQL="UPDATE item SET Description=?,Category=?,QtyOnHand=?,UnitPrice=? WHERE ItemCode=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1,Description);
            preparedStatement.setObject(2,Category);
            preparedStatement.setObject(3,Qty);
            preparedStatement.setObject(4,UnitPrice);
            preparedStatement.setObject(5,Item_Code);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<ItemInfoDto> getAllItems() {
        ObservableList<ItemInfoDto>itemDetails= javafx.collections.FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakadesystem", "root", "20051216");
            PreparedStatement pstm=connection.prepareStatement("SELECT * FROM item");
            java.sql.ResultSet resultSet=pstm.executeQuery();
            while (resultSet.next()){
                itemDetails.add(new ItemInfoDto(
                        resultSet.getString("ItemCode"),
                        resultSet.getString("Description"),
                        resultSet.getString("Category"),
                        resultSet.getInt("QtyOnHand"),
                        resultSet.getDouble("UnitPrice")

                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDetails;
    }

}

