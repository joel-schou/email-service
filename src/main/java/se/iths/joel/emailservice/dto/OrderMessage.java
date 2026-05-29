package se.iths.joel.emailservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderMessage {
    private String customerEmail;
    private double totalPrice;
    private List<OrderItemMessage> items;
}