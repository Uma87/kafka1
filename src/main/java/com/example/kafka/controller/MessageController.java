package com.example.kafka.controller;

import com.example.kafka.controller.model.Message;
import com.example.kafka.service.ptoducer.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class MessageController {
    private final ProducerService producerService;

    @GetMapping("/")
    public String sendMassage(@RequestBody Message message){
        return message.getMessage();
    }

}
