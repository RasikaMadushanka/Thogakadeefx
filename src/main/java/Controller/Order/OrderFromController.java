package Controller.Order;

import Model.dto.OrderDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

public class OrderFromController implements Initializable {
    ObservableList<OrderDto>orderDtos= FXCollections.observableArrayList();
    orderService Order= new orderController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderid.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colCustomerid.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colOrderdate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        // Load data into the table view
        ordertableview.getSelectionModel().selectedItemProperty().addListener( (observable,oldvalue, newvalue) -> {
            OrderDto orderDto=  newvalue;
            if (orderDto!=null){
                txtorderID.setText(orderDto.getOrderId());
                txtcustomerID.setText(orderDto.getCustomerId());
                txtorderDate.setText(orderDto.getOrderDate());
            }
        });

    }
    void clear(){
        txtcustomerID.clear();
        txtorderDate.clear();
        txtorderID.clear();
    }
    private void loadorder(){
        orderDtos.clear();
        ordertableview.setItems(Order.getAllOrder());

    }
    @FXML
    private TableColumn<?, ?> colCustomerid;

    @FXML
    private TableColumn<?, ?> colOrderdate;

    @FXML
    private TableColumn<?, ?> colOrderid;

    @FXML
    private TableView<OrderDto> ordertableview;

    @FXML
    private TextField txtcustomerID;

    @FXML
    private TextField txtorderDate;

    @FXML
    private TextField txtorderID;

    @FXML
    void btnaddOrder(ActionEvent event) {
        String Id=txtorderID.getText();
        String CustomerId=txtcustomerID.getText();
        String date=txtorderDate.getText();

        Order.addOrder(Id,CustomerId,date);
        clear();
        loadorder();


    }

    @FXML
    void btndeleteOrder(ActionEvent event) {
        Order.deleteOrder(txtorderID.getText());
        clear();
        loadorder();

    }

    @FXML
    void btnupdateOrder(ActionEvent event) {
        String Id=txtorderID.getText();
        String CustomerId=txtcustomerID.getText();
        String date=txtorderDate.getText();

        Order.updateOrder(Id,date,CustomerId);
    }

   
}







