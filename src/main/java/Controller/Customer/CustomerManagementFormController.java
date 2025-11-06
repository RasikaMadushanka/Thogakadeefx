package Controller.Customer;

import Model.dto.CustomerInfoDto;
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

public class CustomerManagementFormController implements Initializable {
    ObservableList<CustomerInfoDto>customerInfoDtos= FXCollections.observableArrayList();
    CustomerService customerService=new CustomerManagementController();



    @FXML
    private TableColumn<?, ?> ColAddress;

    @FXML
    private TableColumn<?, ?> ColCity;

    @FXML
    private TableColumn<?, ?> ColCus_id;

    @FXML
    private TableColumn<?, ?> ColDob;

    @FXML
    private TableColumn<?, ?> ColName;

    @FXML
    private TableColumn<?, ?> ColProvince;

    @FXML
    private TableColumn<?, ?> ColSalary;

    @FXML
    private TableColumn<?, ?> Colpostalcode;

    @FXML
    private TableColumn<?, ?> Coltitle;

    @FXML
    private TableView<CustomerInfoDto> tblCustomer;

    @FXML
    private TextField txtCusDob;

    @FXML
    private TextField txtCusId;

    @FXML
    private TextField txtCusName;

    @FXML
    private TextField txtCusPostalcode;

    @FXML
    private TextField txtCusProvince;

    @FXML
    private TextField txtCusSalary;

    @FXML
    private TextField txtCusTitle;

    @FXML
    private TextField txtCusaddress;


    @FXML
    private TextField txtCity;

    @FXML
    void btnAddCustomer(ActionEvent event) {
        String CustomerID=txtCusId.getText();
        String Title=txtCusTitle.getText();
        String Name=txtCusName.getText();
        String Dob=txtCusDob.getText();
        Double Salary= Double.valueOf(txtCusSalary.getText());
        String Address =txtCusaddress.getText();
        String City =txtCity.getText();
        String Province=txtCusProvince.getText();
        String Posatalcode=txtCusPostalcode.getText();

        customerService.addCustomer(CustomerID,Title,Name,Dob,Salary,Address,City,Province,Posatalcode);
        clear();
        loadCustomer();

    }
        void clear(){
        txtCusId.clear();
        txtCusTitle.clear();
        txtCusName.clear();
        txtCusDob.clear();
        txtCusSalary.clear();
        txtCusaddress.clear();
        txtCity.clear();
        txtCusProvince.clear();
        txtCusPostalcode.clear();
        }
    @FXML
    void btnClearCustomer(ActionEvent event) {
        clear();

    }

    @FXML
    void btnDeleteCustomer(ActionEvent event) {
        customerService.deleteCustomer(txtCusId.getText());
        clear();
        loadCustomer();



    }

    @FXML
    void btnUpdateCustomer(ActionEvent event) {
        String id = txtCusId.getText();
        String title = txtCusTitle.getText();
        String name = txtCusName.getText();
        String dob = txtCusDob.getText();
        double salary = Double.parseDouble(txtCusSalary.getText());
        String address = txtCusaddress.getText();
        String city = txtCity.getText();
        String province = txtCusProvince.getText();
        String postalCode = txtCusPostalcode.getText();

        customerService.updatecustomer(id,title,name,dob,salary,address,city,province,postalCode);
        clear();
        loadCustomer();


    }
    private void loadCustomer(){
        customerInfoDtos.clear();
        tblCustomer.setItems(customerService.getAllCustomers());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ColCus_id.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        Coltitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        ColSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        ColAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        ColCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        ColProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        Colpostalcode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));
        loadCustomer();
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observavle,oldvalue,newvalue)->{
            CustomerInfoDto customerInfoDto=newvalue;
            if(customerInfoDto!=null){
                txtCusId.setText(customerInfoDto.getCusId());
                txtCusTitle.setText(customerInfoDto.getTitle());
                txtCusName.setText(customerInfoDto.getName());
                txtCusDob.setText(customerInfoDto.getDob());
                txtCusSalary.setText(String.valueOf(customerInfoDto.getSalary()));
                txtCusaddress.setText(customerInfoDto.getAddress());
                txtCity.setText(customerInfoDto.getCity());
                txtCusProvince.setText(customerInfoDto.getProvince());
                txtCusPostalcode.setText(customerInfoDto.getPostalcode());
            }

        });

    }
}
