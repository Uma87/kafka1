package com.example.kafka.service.consumer;

import com.example.kafka.controller.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {
    @KafkaListener(id = "messageListener",topics = "messages")
    public void getMessages(Message message){
        log.info("Сообщение получено: {}",message);
    }

}
