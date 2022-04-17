package com.example.kafka.service.ptoducer;

import com.example.kafka.controller.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@PropertySource(value = "classpath:kafka.properties")
@ConfigurationProperties(prefix = "kafka")
public class ProducerService {
    private KafkaTemplate<String, Message> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    public  void sendMassage(Message message){
        log.info("отправляю сообщение в кафку: {}",message);
        kafkaTemplate.send(topic,message);
        log.info("Сообщение отправлено в кафку: {}",message.getMessage());
    }
}
