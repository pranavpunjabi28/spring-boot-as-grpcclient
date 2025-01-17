package com.example.springboot_grpc.mapper;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.springboot_grpc.dto.JsonHelloReq;
import com.example.springboot_grpc.dto.JsonHelloResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T15:31:07+0530",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 21.0.4 (Oracle Corporation)"
)
public class HelloRequestConverterImpl implements HelloRequestConverter {

    @Override
    public HelloRequest toProto(JsonHelloReq jsonHelloReq) {
        if ( jsonHelloReq == null ) {
            return null;
        }

        HelloRequest.Builder helloRequest = HelloRequest.newBuilder();

        helloRequest.setFirstName( jsonHelloReq.getFirstName() );
        helloRequest.setLastName( jsonHelloReq.getLastName() );

        return helloRequest.build();
    }

    @Override
    public JsonHelloResponse toJson(HelloResponse grpcResponse) {
        if ( grpcResponse == null ) {
            return null;
        }

        JsonHelloResponse.JsonHelloResponseBuilder jsonHelloResponse = JsonHelloResponse.builder();

        jsonHelloResponse.greeting( grpcResponse.getGreeting() );
        jsonHelloResponse.adress( grpcResponse.getAdress() );
        jsonHelloResponse.pinCode( grpcResponse.getPinCode() );

        return jsonHelloResponse.build();
    }
}
