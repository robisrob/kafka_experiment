package com.github.robisrob.kafka_experiment.application.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public class KafkaController {

    private static final Logger LOGGER = LoggerFactory.getLogger("alogger");

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
        LOGGER.info(body);
        return body;
    }

    @GetMapping("/callback")
    public String getCallBack(@RequestParam(name = "hub.challenge") String challenge) {
        return challenge;
    }
}
