package se.iths.joel.emailservice.dto;

import lombok.Data;

@Data
public class OrderConfirmationMessage {

    private String email;
    private String customerName;
    private String productName;
    private Integer quantity;
}