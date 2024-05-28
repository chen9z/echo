package com.echo.domain;


import lombok.Data;

import java.util.List;

@Data
public class ChatRequest {
    private String model;
    private boolean stream;
    private float temperature;
    private List<Message> messages;
}
