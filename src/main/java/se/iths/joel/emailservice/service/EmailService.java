package se.iths.joel.emailservice.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import se.iths.joel.emailservice.dto.OrderItemMessage;
import se.iths.joel.emailservice.dto.OrderMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOrderEmail(OrderMessage order) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(order.getCustomerEmail());
        message.setSubject("Orderbekräftelse");
        message.setText(createEmailText(order));

        mailSender.send(message);

        System.out.println("Email sent to: " + order.getCustomerEmail());
    }

    private String createEmailText(OrderMessage order) {

        StringBuilder text = new StringBuilder();

        text.append("Tack för din beställning!\n\n");
        text.append("Din order:\n");

        for (OrderItemMessage item : order.getItems()) {
            text.append(item.getName())
                    .append(" - ")
                    .append(item.getQuantity())
                    .append(" st x ")
                    .append(item.getPrice())
                    .append(" kr\n");
        }

        text.append("\nTotalt: ")
                .append(order.getTotalPrice())
                .append(" kr");

        return text.toString();
    }
}
