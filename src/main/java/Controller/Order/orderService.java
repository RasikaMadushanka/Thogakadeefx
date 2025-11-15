package Controller.Order;

import Model.dto.CustomerInfoDto;
import Model.dto.OrderDto;
import javafx.collections.ObservableList;

public interface orderService {
    public void addOrder(String OrderID, String OrderDate, String CustomerID);
    public void deleteOrder(String OrderID);
    public void updateOrder(String OrderID, String OrderDate, String CustomerID);
    ObservableList<OrderDto> getAllOrder();

}
