package com.example.springboot_grpc.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JsonHelloResponse {
    private String greeting;
    private String adress;
    private String pinCode;
}
