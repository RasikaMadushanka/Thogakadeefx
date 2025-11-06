package Controller.Customer;

import Model.dto.CustomerInfoDto;
import javafx.collections.ObservableList;

public interface CustomerService {
    void addCustomer(String CustomerID, String Title, String Name, String Dob, double Salary, String Address, String City, String Province, String Posatalcode);
    void deleteCustomer(String CustomerID);
    void updatecustomer(String id, String Title, String Name, String Dob, double Salary, String Address, String City, String Province, String PostalCode);
    ObservableList<CustomerInfoDto> getAllCustomers();
}
