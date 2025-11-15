package Controller.Order;

import Model.dto.CustomerInfoDto;
import Model.dto.OrderDto;
import db.DBConnection;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class orderController implements  orderService{
    @Override
    public void addOrder(String OrderID, String OrderDate, String CustomerID) {

    }

    @Override
    public void deleteOrder(String OrderID) {

    }

    @Override
    public void updateOrder(String OrderID, String OrderDate, String CustomerID) {

    }

    @Override
    public ObservableList<OrderDto> getAllOrder() {
        ObservableList<OrderDto> orderdetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection= DBConnection.getInstance().getConnection();
            String SQL="SELECT * FROM orders";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){
            orderdetails.add(
                    new OrderDto(
                            resultSet.getString("orderId"),
                            resultSet.getString("orderDate"),
                            resultSet.getString("customerID")
                    )
            );
            }
            return orderdetails;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
