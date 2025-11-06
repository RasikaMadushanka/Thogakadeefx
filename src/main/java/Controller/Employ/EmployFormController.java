package Controller.Employ;


import Model.dto.EmployDto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class EmployFormController implements Initializable {
    ObservableList<EmployDto> employDtos = FXCollections.observableArrayList();
    EmployService employService = new EmployController();

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContactNumber;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colJoinDate;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableView<EmployDto> tblEmployee;

    @FXML
    private TextField txtadress;

    @FXML
    private TextField txtdate;

    @FXML
    private TextField txtdob;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtnic;

    @FXML
    private TextField txtnumber;

    @FXML
    private TextField txtposition;

    @FXML
    private TextField txtsalary;

    @FXML
    private TextField txtstatus;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String EmployeeId = txtid.getText();
        String Name = txtname.getText();
        String Nic = txtnic.getText();
        String Dob = txtdob.getText();
        String Position = txtposition.getText();
        Double Salary = Double.valueOf(txtsalary.getText());
        String Contactnumber = txtnumber.getText();
        String Address = txtadress.getText();
        String Date = txtdate.getText();
        String Status = txtstatus.getText();

        employService.addEmploy(EmployeeId, Name, Nic, Dob, Position, Salary, Contactnumber, Address, Date, Status);
        clear();
        loadEmployee();


    }

    void clear() {
        txtid.clear();
        txtname.clear();
        txtnic.clear();
        txtdob.clear();
        txtposition.clear();
        txtsalary.clear();
        txtnumber.clear();
        txtadress.clear();
        txtdate.clear();
        txtstatus.clear();
    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clear();
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        employService.deleteEmploy(txtid.getText());
        loadEmployee();
        clear();


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String Name = txtname.getText();
        String Nic = txtnic.getText();
        String Dob = txtdob.getText();
        String Position = txtposition.getText();
        Double Salary = Double.valueOf(txtsalary.getText());
        String Contactnumber = txtnumber.getText();
        String Address = txtadress.getText();
        String Date = txtdate.getText();
        String Status = txtstatus.getText();
        String EmployeeId = txtid.getText();
        employService.updateEmploy(EmployeeId, Name, Nic, Dob, Position, Salary, Contactnumber, Address, Date, Status);
        clear();
        loadEmployee();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("Nic"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("Position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colJoinDate.setCellValueFactory(new PropertyValueFactory<>("joindate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        loadEmployee();
        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observable, oldvalue, newvalue) -> {
            EmployDto employDto = newvalue;
            if (employDto != null) {
                txtid.setText(employDto.getId());
                txtname.setText(employDto.getName());
                txtnic.setText(employDto.getNic());
                txtdob.setText(employDto.getDob());
                txtposition.setText(employDto.getPosition());
                txtsalary.setText(String.valueOf(employDto.getSalary()));
                txtnumber.setText(employDto.getContactNumber());
                txtadress.setText(employDto.getAddress());
                txtdate.setText(employDto.getJoindate());
                txtstatus.setText(employDto.getStatus());

            }

        });


    }

    private void loadEmployee() {
        employDtos.clear();
        tblEmployee.setItems(employService.getAllEmploy());
    }
}



