package Controller.Customer;

import db.DBConnection;
import Model.dto.CustomerInfoDto;
import javafx.collections.ObservableList;

import java.sql.*;


public class CustomerManagementController implements CustomerService {
    @Override
    public void addCustomer(String CustomerID, String Title, String Name, String Dob, double Salary, String Address, String City, String Province, String Posatalcode) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, CustomerID);
            preparedStatement.setString(2, Title);
            preparedStatement.setString(3, Name);
            preparedStatement.setString(4, Dob);
            preparedStatement.setDouble(5, Salary);
            preparedStatement.setString(6, Address);
            preparedStatement.setString(7, City);
            preparedStatement.setString(8, Province);
            preparedStatement.setString(9, Posatalcode);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //delete customer
    @Override
    public void deleteCustomer(String CustomerID) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM customer WHERE CusID=?");
            pstm.setString(1, CustomerID);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //update customer
    @Override
    public void updatecustomer(String id, String Title, String Name, String Dob, double Salary, String Address, String City, String Province, String PostalCode) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL = "UPDATE customer SET Title=?,Name=?,DOB=?,Salary=?,Address=?,City=?,Province=?,PostalCode=? WHERE CusID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, Title);
            preparedStatement.setObject(2, Name);
            preparedStatement.setObject(3, Dob);
            preparedStatement.setObject(4, Salary);
            preparedStatement.setObject(5, Address);
            preparedStatement.setObject(6, City);
            preparedStatement.setObject(7, Province);
            preparedStatement.setObject(8, PostalCode);
            preparedStatement.setObject(9, id);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<CustomerInfoDto> getAllCustomers() {
        ObservableList<CustomerInfoDto> customerDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM Customer";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                customerDetails.add(new CustomerInfoDto(
                                resultSet.getString("CusID"),
                                resultSet.getString("Title"),
                                resultSet.getString("Name"),
                                resultSet.getString("DOB"),
                                resultSet.getDouble("Salary"),
                                resultSet.getString("Address"),
                                resultSet.getString("City"),
                                resultSet.getString("Province"),
                                resultSet.getString("PostalCode")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerDetails;
    }
}

