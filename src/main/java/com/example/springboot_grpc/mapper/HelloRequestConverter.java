package com.example.springboot_grpc.mapper;//package com.example.springboot_grpc.mapper;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.springboot_grpc.dto.JsonHelloReq;
import com.example.springboot_grpc.dto.JsonHelloResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface HelloRequestConverter {

   HelloRequestConverter instance = Mappers.getMapper(HelloRequestConverter.class);

    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    HelloRequest toProto(JsonHelloReq jsonHelloReq);


    @Mapping(source = "greeting" ,target = "greeting")
    @Mapping(source = "adress",target = "adress")
    @Mapping(source = "pinCode" ,target = "pinCode")
    JsonHelloResponse toJson(HelloResponse grpcResponse);
}
