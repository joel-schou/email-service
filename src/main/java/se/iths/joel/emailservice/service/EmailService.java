package se.iths.joel.emailservice.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String email,
                          String customerName,
                          String productName,
                          Integer quantity) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Order Confirmation");

        message.setText(
                "Hej " + customerName + "\n\n" +
                        "Din beställning har registrerats.\n" +
                        "Produkt: " + productName + "\n" +
                        "Antal: " + quantity
        );

        mailSender.send(message);
    }
}