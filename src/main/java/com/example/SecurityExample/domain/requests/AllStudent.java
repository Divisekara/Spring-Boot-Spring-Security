package com.example.SecurityExample.domain.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllStudent {
    @JsonProperty("data")
    private ArrayList<StudentRequest> data;
}
