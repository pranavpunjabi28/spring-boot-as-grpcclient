package com.example.springboot_grpc.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AbstractJsonHelloResponse {
    private String greeting;
}
