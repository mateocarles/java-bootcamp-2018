package com.globant.shoppingcartdemoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private int paymentId;
    private int clientId;
    private int orderId;
    private float amount;


}
