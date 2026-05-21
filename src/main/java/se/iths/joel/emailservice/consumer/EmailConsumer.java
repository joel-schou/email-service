package se.iths.joel.emailservice.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.joel.emailservice.dto.OrderConfirmationMessage;
import se.iths.joel.emailservice.service.EmailService;

@Component
public class EmailConsumer {

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.email}")
    public void receiveOrderConfirmation(OrderConfirmationMessage message) {
        emailService.sendEmail(
                message.getEmail(),
                message.getCustomerName(),
                message.getProductName(),
                message.getQuantity()
        );
    }
}