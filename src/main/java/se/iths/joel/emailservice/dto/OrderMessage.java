package se.iths.joel.emailservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderMessage {
    private String customerName;
    private BigDecimal totalPrice;
    private List<OrderItemMessage> orderItems;
}