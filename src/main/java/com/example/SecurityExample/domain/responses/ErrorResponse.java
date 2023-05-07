package com.example.SecurityExample.domain.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @JsonProperty("code")
    private Integer code;

    @JsonProperty("description")
    private String msg;

    @JsonProperty("trace")
    private UUID trace;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();
}
