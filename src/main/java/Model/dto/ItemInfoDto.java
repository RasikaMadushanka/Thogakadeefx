package Model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ItemInfoDto {
    private String itemCode;
    private String description;
    private String category;
    private int qtyOnHand;
    private double unitPrice;

}
