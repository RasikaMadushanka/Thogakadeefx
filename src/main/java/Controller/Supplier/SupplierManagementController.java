package Controller.Supplier;

import db.DBConnection;
import Model.dto.SupplierInfoDto;
import javafx.collections.ObservableList;

import java.sql.*;

public class SupplierManagementController implements SupplierService {



    @Override
    public void addSupplier(String SupplierId, String Name, String CompanyName, String Address, String City, String Province, String Phone, String email, String postalcode) {
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            String SQL = "INSERT INTO Supplier VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, SupplierId);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, CompanyName);
            preparedStatement.setString(4, Address);
            preparedStatement.setString(5, City);
            preparedStatement.setString(6, Province);
            preparedStatement.setString(7, Phone);
            preparedStatement.setString(8, email);
            preparedStatement.setString(9, postalcode);
            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteSupplier(String SupplierId) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement pstm =connection.prepareStatement("DELETE FROM Supplier WHERE SupplierId=?");
            pstm.setObject(1,SupplierId);
            pstm.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateSupplier(String SupplierId, String Name, String CompanyName, String Address, String City, String Province, String Phone, String email, String postalcode){
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL="UPDATE Supplier SET Name=?,CompanyName=?,Address=?,City=?,Province=?,Phone=?,email=?,postalcode=? WHERE SupplierId=?";
            PreparedStatement preparedStatement=connection.prepareStatement(SQL);
            preparedStatement.setString(1,Name);
            preparedStatement.setString(2,CompanyName);
            preparedStatement.setString(3,Address);
            preparedStatement.setString(4,City);
            preparedStatement.setString(5,Province);
            preparedStatement.setString(6,Phone);
            preparedStatement.setString(7,email);
            preparedStatement.setString(8,postalcode);
            preparedStatement.setString(9,SupplierId);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<SupplierInfoDto> getAllSuppliers() {
        ObservableList<SupplierInfoDto> supplierInfoDtos= javafx.collections.FXCollections.observableArrayList();
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM Supplier");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                SupplierInfoDto supplierInfoDto =new SupplierInfoDto(
                        resultSet.getString("SupplierID"),
                        resultSet.getString("Name"),
                        resultSet.getString("CompanyName"),
                        resultSet.getString("Address"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getString("PostalCode"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email")              );


                supplierInfoDtos.add(supplierInfoDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supplierInfoDtos;
    }

}
