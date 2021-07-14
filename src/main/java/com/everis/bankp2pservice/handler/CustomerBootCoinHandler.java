package com.everis.bankp2pservice.handler;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.everis.bankp2pservice.model.document.CustomerBootCoinDoc;
import com.everis.bankp2pservice.model.service.CustomerBootCoinService;

import reactor.core.publisher.Mono;

@Component
public class CustomerBootCoinHandler {
  
  @Autowired
  private CustomerBootCoinService customerBootCoinService;
  
  public Mono<ServerResponse> listCustomerBootCoin(ServerRequest request){
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(customerBootCoinService.findAll(),CustomerBootCoinDoc.class);
  }
  
  public Mono<ServerResponse> listCustomerBootCoinId(ServerRequest request){
    String id = request.pathVariable("id");
    return customerBootCoinService.findById(id).flatMap(p -> ServerResponse
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromObject(p)))
        .switchIfEmpty(ServerResponse.notFound().build());
  }

}
