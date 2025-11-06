package Controller.Item;

public interface ItemService {

    void addItem(String itemCode, String description, String category, int qtyOnHand, double unitPrice);
    void deleteItem(String itemCode);
    void updateItem(String itemCode, String description, String category, int qtyOnHand, double unitPrice);
    javafx.collections.ObservableList<Model.dto.ItemInfoDto> getAllItems();
}
