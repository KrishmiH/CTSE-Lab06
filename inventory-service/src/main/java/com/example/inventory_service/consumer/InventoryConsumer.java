package com.example.inventory_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void consume(String message) {
        System.out.println("Inventory Service received event: " + message);
        System.out.println("Inventory updated for incoming order.");
    }
}