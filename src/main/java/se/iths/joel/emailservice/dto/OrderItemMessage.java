package se.iths.joel.emailservice.dto;

import lombok.Data;

@Data
public class OrderItemMessage {
    private String name;
    private double price;
    private int quantity;
}