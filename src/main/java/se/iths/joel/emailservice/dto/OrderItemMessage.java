package se.iths.joel.emailservice.dto;

import lombok.Data;

/**
 * Beskriver en orderrad med produktnamn, pris och antal.
 */
@Data
public class OrderItemMessage {
    private String name;
    private double price;
    private int quantity;
}
