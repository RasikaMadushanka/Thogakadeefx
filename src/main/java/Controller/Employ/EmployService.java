package Controller.Employ;

import Model.dto.EmployDto;
import javafx.collections.ObservableList;

public interface EmployService {

    void addEmploy(String EmployeeId, String Name, String Nic, String Dob, String Position, double Salary, String Contactnumber, String Address, String Date, String Status);

    void deleteEmploy(String empID);

    void updateEmploy(String EmployeeId, String Name, String Nic, String Dob, String Position, double Salary, String Contactnumber, String Address, String Date, String Status);

    ObservableList<EmployDto> getAllEmploy();
}
