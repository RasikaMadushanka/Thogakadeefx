package Controller.Supplier;

import Model.dto.SupplierInfoDto;
import javafx.collections.ObservableList;

public interface SupplierService {

    void addSupplier(String SupplierId, String Name, String CompanyName, String Address, String City, String Province, String Phone, String email, String postalcode);

    void deleteSupplier(String SupplierID);
    void updateSupplier(String SupplierId, String Name, String CompanyName, String Address, String City, String Province, String Phone, String email, String postalcode);

    ObservableList<SupplierInfoDto> getAllSuppliers();

}
