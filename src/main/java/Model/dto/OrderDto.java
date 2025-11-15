package Model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class OrderDto {
    private String orderId;
    private String orderDate;
    private String customerId;

}
