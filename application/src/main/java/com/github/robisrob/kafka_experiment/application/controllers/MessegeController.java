package com.github.robisrob.kafka_experiment.application.controllers;

import com.github.robisrob.kafka_experiment.application.services.MessageProducer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


@RestController
public class MessegeController {

    private final MessageProducer messageProducer;

    public MessegeController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/message")
    @ResponseBody
    String postMessage(@RequestBody MessageTo messageTo) {
        messageProducer.produceMessage(messageTo);
        return "lijkt gelukt";
    }
}
