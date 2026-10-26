# Email-service

## Översikt

En mikrotjänst som tar emot orderinformation från order-service via RabbitMQ och skickar en orderbekräftelse till
kundens e-postadress via SMTP. Orderbekräftelsen innehåller beställda produkter, antal, pris och orderns totalbelopp.

Order-service publicerar ordermeddelanden till RabbitMQ-kön `email-queue`, där email-service tar emot och behandlar
dem. Tjänsten är en del av ett större projekt för att skapa en webbshop. Länkar till de relaterade programmen och
deras GitHub-repositories finns längre ner.

## Teknisk specifikation

Teknikstack: Java JDK 17, Maven, Spring Boot 4.0.6, Spring Boot Mail, Spring AMQP, RabbitMQ, Spring Web MVC,
Spring Data JPA, H2, PostgreSQL och Lombok.
Databas: H2 används som standard och PostgreSQL kan konfigureras med miljövariabler.
Port (localhost): 8083.
CI-workflow: Java CI med Maven.
Containerisering: Docker.

## Miljövariabler

- `SERVER_PORT`
- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`
- `DB_DRIVER`
- `DB_DIALECT`
- `RABBITMQ_HOST`
- `RABBITMQ_PORT`
- `RABBITMQ_USERNAME`
- `RABBITMQ_PASSWORD`
- `RABBITMQ_VIRTUAL_HOST`
- `RABBITMQ_EMAIL_QUEUE`
- `MAIL_HOST`
- `MAIL_PORT`
- `MAIL_USERNAME`
- `MAIL_PASSWORD`
- `MAIL_SMTP_AUTH`
- `MAIL_SMTP_STARTTLS`

RabbitMQ-lyssnaren använder för närvarande kön `email-queue`, så `RABBITMQ_EMAIL_QUEUE` måste ha samma värde.

## Start

Se till att RabbitMQ är startat och att SMTP-inställningarna är konfigurerade innan tjänsten startas.

**I terminalen**

Windows: `mvnw.cmd spring-boot:run`

macOS/Linux: `./mvnw spring-boot:run`

**IntelliJ IDEA**

1. Ladda ner projektet från GitHub och öppna det i IntelliJ.
2. Kontrollera att beroendena i `pom.xml` har lästs in korrekt och synkroniserats med projektet.
3. Konfigurera miljövariablerna för RabbitMQ, SMTP och eventuell extern databas.
4. Tryck på startknappen och kontrollera att huvudmetoden i `EmailServiceApplication` är vald.

## Repositories

Auth-service: https://github.com/katttiger/auth-service

Product-service: https://github.com/Joajak92/product-service

Order-service: https://github.com/klasen98/projekt-order-service

Gateway-service: https://github.com/joel-schou/gateway-service

Frontend: https://github.com/Joajak92/webshop-frontend
