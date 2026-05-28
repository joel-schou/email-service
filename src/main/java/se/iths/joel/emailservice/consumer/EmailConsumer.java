package se.iths.joel.emailservice.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.joel.emailservice.dto.OrderMessage;
import se.iths.joel.emailservice.service.EmailService;

@Component
public class EmailConsumer {

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "email-queue")
    public void receiveOrder(OrderMessage order) {

        System.out.println("Email-service received order successfully");
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Total price: " + order.getTotalPrice());
        System.out.println("Items: " + order.getOrderItems());

        emailService.sendOrderEmail(order);
    }
}