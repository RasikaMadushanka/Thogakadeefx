package Controller.Supplier;

import Model.dto.SupplierInfoDto;
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


public class SupplerManagementFormController implements Initializable {
    SupplierService supplierService = new SupplierManagementController();


    ObservableList<SupplierInfoDto> supplierInfoDtos = FXCollections.observableArrayList();


    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colcity;

    @FXML
    private TableColumn<?, ?> colcompanyName;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TableColumn<?, ?> colphone;

    @FXML
    private TableColumn<?, ?> colpostalcode;

    @FXML
    private TableColumn<?, ?> colprovince;

    @FXML
    private TableColumn<?, ?> colsupplierid;

    @FXML
    private TableView<SupplierInfoDto> tblSupllier;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtcity;

    @FXML
    private TextField txtcompanyName;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtpostalCode;

    @FXML
    private TextField txtprovince;

    @FXML
    private TextField txtsupplierId;

    @FXML
    void btnaddSupplierOnaction(ActionEvent event) {
        String SupplierId=txtsupplierId.getText();
        String Name=txtname.getText();
        String  CompanyName=txtcompanyName.getText();
        String Address =txtaddress.getText();
        String City=txtcity.getText();
        String Province=txtprovince.getText();
        String Phone=txtphone.getText();
        String email=txtemail.getText();
        String postalcode=txtpostalCode.getText();
        supplierService.addSupplier(SupplierId,Name,CompanyName,Address,City,Province,Phone,email,postalcode);
        clear();
        loadAllSuppliers();





    }
    void clear(){
        txtsupplierId.clear();
        txtname.clear();;
        txtcompanyName.clear();
        txtaddress.clear();
        txtcity.clear();
        txtprovince.clear();
        txtphone.clear();
        txtemail.clear();
        txtpostalCode.clear();
    }

    @FXML
    void btnclearSupplierOnaction(ActionEvent event) {
        clear();
    }

    @FXML
    void btndeleteSupllierOnaction(ActionEvent event) {
        supplierService.deleteSupplier(txtsupplierId.getText());
        clear();
        loadAllSuppliers();
    }

    @FXML
    void btnupdateSupplierOnaction(ActionEvent event) {


                String Name=txtname.getText();
                String  CompanyName=txtcompanyName.getText();
                String Address =txtaddress.getText();
                String City=txtcity.getText();
                String Province=txtprovince.getText();
                String Phone=txtphone.getText();
                String email=txtemail.getText();
                String postalcode=txtpostalCode.getText();
                String SupplierId=txtsupplierId.getText();
                supplierService.updateSupplier(SupplierId,Name,CompanyName,Address,City,Province,Phone,email,postalcode);
                clear();
                loadAllSuppliers();

    }
    private void loadAllSuppliers(){
        supplierInfoDtos.clear();
      tblSupllier.setItems(supplierService.getAllSuppliers());



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colsupplierid.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colcompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colcity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colprovince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colpostalcode.setCellValueFactory(new PropertyValueFactory<>("postalcode"));
        loadAllSuppliers();
        tblSupllier.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)->{
            SupplierInfoDto supplierInfoDto=newvalue;
            if(supplierInfoDto!=null){
                txtsupplierId.setText(supplierInfoDto.getSupplierId());
                txtname.setText(supplierInfoDto.getName());
                txtcompanyName.setText(supplierInfoDto.getCompanyName());
                txtaddress.setText(supplierInfoDto.getAddress());
                txtcity.setText(supplierInfoDto.getCity());
                txtprovince.setText(supplierInfoDto.getProvince());
                txtphone.setText(supplierInfoDto.getPhone());
                txtemail.setText(supplierInfoDto.getEmail());
                txtpostalCode.setText(supplierInfoDto.getPostalcode());

            }
        });
    }
}
