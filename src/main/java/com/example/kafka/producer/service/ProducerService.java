package com.example.kafka.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {

    private final KafkaTemplate<Long, String> kafkaTemplate;

    public void publish(String message) {
        Long key = System.currentTimeMillis();
        kafkaTemplate.send("test-topic", key, message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        log.info("Publish success: {}", key);
                    } else {
                        log.error("Publish failed: {}", ex.getMessage());
                    }
                });
    }
}
