package com.globant.shoppingcartdemoapp.dto;



import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {


    private int clientId;

    private String name;

    private String lastName;

    private String description;

    private List<String> paymentIds;

}