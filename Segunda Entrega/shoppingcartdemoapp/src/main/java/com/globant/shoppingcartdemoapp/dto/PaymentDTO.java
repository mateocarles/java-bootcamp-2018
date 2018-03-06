package com.globant.shoppingcartdemoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private int paymentId;
    private int orderId;
    private float amount;

    public PaymentDTO(int orderId, float amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
}
