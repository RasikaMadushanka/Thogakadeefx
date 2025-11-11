package Controller.Employ;

import db.DBConnection;
import Model.dto.EmployDto;
import javafx.collections.ObservableList;

import java.sql.*;

public class EmployController implements EmployService {


    @Override
    public void addEmploy(String EmployeeId, String Name, String Nic, String Dob, String Position, double Salary, String Contactnumber, String Address, String Date, String Status) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, EmployeeId);
            preparedStatement.setString(2, Name);
            preparedStatement.setString(3, Nic);
            preparedStatement.setString(4, Dob);
            preparedStatement.setString(5, Position);
            preparedStatement.setDouble(6, Salary);
            preparedStatement.setString(7, Contactnumber);
            preparedStatement.setString(8, Address);
            preparedStatement.setString(9, Date);
            preparedStatement.setString(10, Status);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }
    @Override
    public void deleteEmploy(String EmployeeID){
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            PreparedStatement estm=connection.prepareStatement("DELETE FROM employee WHERE EmployeeID=?");
            estm.setString(1,EmployeeID);
            estm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public void updateEmploy(String EmployeeId, String Name, String Nic, String Dob, String Position, double Salary, String Contactnumber, String Address, String Date, String Status){
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL="UPDATE employee SET Name=?,NIC=?,DateOfBirth=?,Position=?,Salary=?,ContactNumber=?,Address=?,JoinedDate=?,Status=? WHERE EmployeeID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,Name);
            preparedStatement.setString(2,Nic);
            preparedStatement.setString(3,Dob);
            preparedStatement.setString(4,Position);
            preparedStatement.setDouble(5,Salary);
            preparedStatement.setString(6,Contactnumber);
            preparedStatement.setString(7,Address);
            preparedStatement.setString(8,Date);
            preparedStatement.setString(9,Status);
            preparedStatement.setString(10,EmployeeId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public ObservableList<EmployDto> getAllEmploy() {
        ObservableList<EmployDto> employDetails = javafx.collections.FXCollections.observableArrayList();

        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String SQL = "SELECT * FROM Employee";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                employDetails.add(new EmployDto(
                        resultSet.getString("EmployeeID"),
                        resultSet.getString("Name"),
                        resultSet.getString("NIC"),
                        resultSet.getString("DateOfBirth"),
                        resultSet.getString("Position"),
                        resultSet.getDouble("Salary"),
                        resultSet.getString("ContactNumber"),
                        resultSet.getString("Address"),
                        resultSet.getString("JoinedDate"),
                        resultSet.getString("Status")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employDetails;
    }
}
