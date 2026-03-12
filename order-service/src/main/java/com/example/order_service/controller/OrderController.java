package com.example.order_service.controller;

import com.example.order_service.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        String event = "Order Created: ID=" + order.getOrderId()
                + ", Item=" + order.getItem()
                + ", Quantity=" + order.getQuantity();

        kafkaTemplate.send("order-topic", event);

        System.out.println("Published event to Kafka: " + event);

        return "Order Created & Event Published";
    }
}