package com.example.billing_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BillingConsumer {

    @KafkaListener(topics = "order-topic", groupId = "billing-group")
    public void consume(String message) {
        System.out.println("Billing Service received event: " + message);
        System.out.println("Invoice generated for incoming order.");
    }
}