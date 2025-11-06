package Model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployDto {
    private String Id;
    private String Name;
    private String Nic;
    private String Dob;
    private String Position;
    private Double Salary;
    private String ContactNumber;
    private String Address;
    private String joindate;
    private String Status;

}
