package se.iths.joel.emailservice.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.joel.emailservice.dto.OrderMessage;
import se.iths.joel.emailservice.service.EmailService;

/**
 * Tar emot ordermeddelanden från RabbitMQ och skickar dem vidare till e-posttjänsten.
 */
@Component
public class EmailConsumer {

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "email-queue")
    public void receiveOrder(OrderMessage order) {

        System.out.println("Email-service received order successfully");
        System.out.println("Customer: " + order.getCustomerEmail());
        System.out.println("Total price: " + order.getTotalPrice());
        System.out.println("Items: " + order.getItems());

        emailService.sendOrderEmail(order);
    }
}
