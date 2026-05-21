package se.iths.joel.emailservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger log =
            LoggerFactory.getLogger(EmailService.class);

    public void sendEmail(
            String email,
            String customerName,
            String productName,
            Integer quantity) {

        log.info("""
                        Sending email to: {}
                        Customer: {}
                        Product: {}
                        Quantity: {}
                        """,
                email,
                customerName,
                productName,
                quantity);
    }
}