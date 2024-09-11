package com.telecom.gastos.controller;

import com.telecom.gastos.service.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @PostMapping("/send")
    public String sendMessageToKafka(@RequestBody String message) {
        kafkaMessageProducer.sendMessage(message);
        return "Message sent to Kafka: " + message;
    }
}
