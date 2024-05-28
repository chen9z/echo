package com.echo.client;

import com.echo.domain.ChatRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class Httpclient {

    private static final Httpclient INSTANCE = new Httpclient();

    private final WebClient webClient;

    private Httpclient() {
        webClient = WebClient.builder().baseUrl("http://localhost:11434").build();
    }

    public Flux<String> getChatCompletion(ChatRequest request) {
        return webClient.post()
                .uri("/v1/chat/completions")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.TEXT_EVENT_STREAM)
                .bodyValue(request)
                .retrieve()
                .bodyToFlux(String.class);
    }
}
