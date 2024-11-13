package com.example.springboot_grpc.mapper;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.springboot_grpc.dto.AbstractJsonHelloResponse;
import com.example.springboot_grpc.dto.JsonHelloReq;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AbstractHelloRequestMapper {
    AbstractHelloRequestMapper instance = Mappers.getMapper(AbstractHelloRequestMapper.class);

    @Mapping(source = "firstName",target = "firstName")
    @Mapping(source = "lastName",target = "lastName")
    default HelloRequest toProto(JsonHelloReq jsonHelloReq) {
     try {
      return HelloRequest.newBuilder().setFirstName(jsonHelloReq.getFirstName()).setLastName(jsonHelloReq.getLastName()).build();
     } catch (RuntimeException e) {
      System.out.println("error in converting request" + e.getMessage());
      throw e;
     }
    }

    @Mapping(source = "greeting" ,target = "greeting")
    default AbstractJsonHelloResponse toJson(HelloResponse grpcResponse) {
     try {
      return AbstractJsonHelloResponse.builder().greeting(grpcResponse.getGreeting()).build();
     } catch (RuntimeException e) {
      System.out.println("error in converting response" + e.getMessage());
      throw e;
     }
    }
}
