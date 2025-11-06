package Controller.Item;

import Model.dto.ItemInfoDto;
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


public class ItemManagementFormController implements Initializable {
    ObservableList<ItemInfoDto>itemInfoDtos= FXCollections.observableArrayList();
    ItemService itemService=new ItemManagementController();
    @FXML
    private TableColumn<?, ?> Colcategory;

    @FXML
    private TableColumn<?, ?> Coldescription;

    @FXML
    private TableColumn<?, ?> Colitem_Code;

    @FXML
    private TableColumn<?, ?> Colquantity;

    @FXML
    private TableColumn<?, ?> Colunit_price;

    @FXML
    private TableView<ItemInfoDto> tblItem;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtUnitprice;

    @FXML
    void btnItemClear(ActionEvent event) {
        clear();
        }
        void clear(){
            txtItemCode.clear();
            txtDescription.clear();
            txtCategory.clear();
            txtQuantity.clear();
            txtUnitprice.clear();
        }



    @FXML
    void btnItemaddOnAction(ActionEvent event) {

        String Item_Code=txtItemCode.getText();
        String Description=txtDescription.getText();
        String Category=txtCategory.getText();
        Integer Qty= Integer.valueOf(txtQuantity.getText());
        Double UnitPrice= Double.valueOf(txtUnitprice.getText());
        itemService.addItem(Item_Code,Description,Category,Qty,UnitPrice);
        clear();
        loadItemDetails();

    }

    @FXML
    void btnitemDeleteOnAction(ActionEvent event) {

        itemService.deleteItem(txtItemCode.getText());
        clear();
        loadItemDetails();


    }

    @FXML
    void btnitemUpdateOnAction(ActionEvent event) {

            String Description=txtDescription.getText();
            String Category=txtCategory.getText();
            String Quantity=txtQuantity.getText();
            String Price=txtUnitprice.getText();
            String Itemcode=txtItemCode.getText();
            itemService.updateItem(Itemcode,Description,Category, Integer.valueOf(Quantity), Double.valueOf(Price));
            clear();
            loadItemDetails();




    }
    private void loadItemDetails(){
        itemInfoDtos.clear();
        tblItem.setItems(itemService.getAllItems());


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Colitem_Code.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        Coldescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        Colcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        Colquantity.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        Colunit_price.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        loadItemDetails();
        tblItem.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newvalue)->{
            ItemInfoDto itemInfoDto=newvalue;
            if(itemInfoDto!=null){
                txtItemCode.setText(itemInfoDto.getItemCode());
                txtDescription.setText(itemInfoDto.getDescription());
                txtCategory.setText(itemInfoDto.getCategory());
                txtQuantity.setText(String.valueOf(itemInfoDto.getQtyOnHand()));
                txtUnitprice.setText(String.valueOf(itemInfoDto.getUnitPrice()));

            }

        });

    }
}
