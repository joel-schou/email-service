package se.iths.joel.emailservice.service;

import org.springframework.stereotype.Service;
import se.iths.joel.emailservice.dto.OrderMessage;

@Service
public class EmailService {

    public void sendOrderEmail(OrderMessage order) {

        System.out.println("Email-service built order email successfully");
        System.out.println("Customer: " + order.getCustomerEmail());
        System.out.println("Total price: " + order.getTotalPrice());
        System.out.println("Items: " + order.getItems());
    }
}