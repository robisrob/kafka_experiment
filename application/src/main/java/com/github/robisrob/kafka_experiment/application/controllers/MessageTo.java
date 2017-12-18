package com.github.robisrob.kafka_experiment.application.controllers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageTo {

    private final String message;

    @JsonCreator
    public MessageTo(@JsonProperty("message") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
