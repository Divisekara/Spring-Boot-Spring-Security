package com.example.SecurityExample.domain.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuccessResponse {
    @JsonProperty("data")
    private data data;
}
