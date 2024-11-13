package com.example.springboot_grpc.service;//package com.example.springboot_grpc.service;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.HelloResponseOrBuilder;
import com.example.grpc.HelloServiceGrpc;
import com.example.springboot_grpc.dto.AbstractJsonHelloResponse;
import com.example.springboot_grpc.dto.JsonHelloReq;
import com.example.springboot_grpc.dto.JsonHelloResponse;
import com.example.springboot_grpc.mapper.AbstractHelloRequestMapper;
import com.example.springboot_grpc.mapper.HelloRequestConverter;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public AbstractJsonHelloResponse hello(JsonHelloReq jsonRequest) {
        try {
            //create channel
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                    .usePlaintext()
                    //Use of a plaintext connection to the server. By default a secure connection mechanism such as TLS will be used.
                    .build();

            //stub create by calling auto generated method
            HelloServiceGrpc.HelloServiceBlockingStub stub
                    = HelloServiceGrpc.newBlockingStub(channel);

//            HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
//                    .setFirstName("pranav")
//                    .setLastName("punjabi")
//                    .build());

            HelloResponse helloResponse = stub.hello(AbstractHelloRequestMapper.instance.toProto(jsonRequest));
            System.out.println(helloResponse);

            channel.shutdown();//Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately cancelled.
            return AbstractHelloRequestMapper.instance.toJson(helloResponse);

        } catch (IllegalStateException e) {
            System.out.println("if ChannelCredentials were provided when constructing the builder while Using PlainText");
            throw e;
        } catch (UnsupportedOperationException e) {
            System.out.println(" if plaintext Or Any given mode is not supported");
            throw e;
        } catch (Exception e) {
            System.out.println("some other exception Occur while doing grpc call");
            throw e;
        }

    }
}
