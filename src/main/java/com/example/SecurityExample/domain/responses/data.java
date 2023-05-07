package com.example.SecurityExample.domain.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class data {
    @JsonProperty("id")
    private Long id;
}
