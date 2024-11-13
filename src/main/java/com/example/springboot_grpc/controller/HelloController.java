package com.example.springboot_grpc.controller;

import com.example.springboot_grpc.dto.AbstractJsonHelloResponse;
import com.example.springboot_grpc.dto.JsonHelloReq;
import com.example.springboot_grpc.dto.JsonHelloResponse;
import com.example.springboot_grpc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("hello")
    public ResponseEntity<AbstractJsonHelloResponse> hello(@RequestBody JsonHelloReq jsonRequest) {

        try {
            AbstractJsonHelloResponse response = helloService.hello(jsonRequest);
            return new ResponseEntity<AbstractJsonHelloResponse>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
