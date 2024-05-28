package com.echo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ChatCompletion {
    @JsonProperty("id")
    private String id;
    @JsonProperty("object")
    private String object;
    @JsonProperty("created")
    private Integer created;
    @JsonProperty("model")
    private String model;
    @JsonProperty("system_fingerprint")
    private String systemFingerprint;
    @JsonProperty("choices")
    private List<ChoicesDTO> choices;

    @Data
    public static class ChoicesDTO {
        @JsonProperty("index")
        private Integer index;
        @JsonProperty("delta")
        private DeltaDTO delta;
        @JsonProperty("logprobs")
        private Object logprobs;
        @JsonProperty("finish_reason")
        private Object finishReason;

        @Data
        public static class DeltaDTO {
            @JsonProperty("role")
            private String role;
            @JsonProperty("content")
            private String content;
        }
    }
}
