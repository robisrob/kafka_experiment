package com.github.robisrob.kafka_experiment.application.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class KafkaController {

    @GetMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(KafkaController.class, args);
    }

    @PostMapping("/callback")
    @ResponseBody
    String home(@RequestBody(required = false) String body) {
        return body;
    }
}
