package se.iths.joel.emailservice.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(String email,
                          String customerName,
                          String productName,
                          Integer quantity) {

        System.out.println(
                "Sending email to: " + email +
                        "\nCustomer: " + customerName +
                        "\nProduct: " + productName +
                        "\nQuantity: " + quantity
        );
    }
}