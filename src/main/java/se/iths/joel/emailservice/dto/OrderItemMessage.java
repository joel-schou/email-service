package se.iths.joel.emailservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemMessage {
    private String name;
    private BigDecimal price;
    private int quantity;
}