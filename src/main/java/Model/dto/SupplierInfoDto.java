package Model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SupplierInfoDto {
    private String supplierId;
    private String name;
    private String companyName;
    private String address;
    private String city;
    private String province;
    private String postalcode;
    private String phone;
    private String email;
}
