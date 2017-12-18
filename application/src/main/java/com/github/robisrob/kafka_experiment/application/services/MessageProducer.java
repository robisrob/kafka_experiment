package com.github.robisrob.kafka_experiment.application.services;

import com.github.robisrob.kafka_experiment.application.controllers.MessageTo;
import org.apache.kafka.clients.producer.*;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.Future;

@Service
public class MessageProducer {

    private final Producer producer;

    public MessageProducer(Producer producer) {
        this.producer = producer;
    }

    public void produceMessage(MessageTo messageTo) {
        ProducerRecord<String, String> record = new ProducerRecord<>("test",
                UUID.randomUUID().toString(), messageTo.getMessage());
        Callback callback = (metadata, exception) -> {
            if (exception != null) {
                System.out.println("Encountered exception " + exception);
            }
        };
         producer.send(record, callback);
    }
}
