package com.example.kafka.service;

import com.example.kafka.producer.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProducerServiceTest {

    @Autowired
    private ProducerService producerService;

    @Test
    void testPublish() {
        producerService.publish("Hello world!");
    }
}
