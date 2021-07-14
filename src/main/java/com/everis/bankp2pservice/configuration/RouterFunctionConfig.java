package com.everis.bankp2pservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.everis.bankp2pservice.handler.CustomerBootCoinHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterFunctionConfig {
  
  @Bean
  public RouterFunction<ServerResponse> routes(CustomerBootCoinHandler handler){
    return route(GET("/api/v2/p2pservice"), handler::listCustomerBootCoin)
        .andRoute(GET("/api/v2/p2pservice/{id}"), handler::listCustomerBootCoinId)
        .andRoute(POST("/api/v2/p2pservice"), handler::addCustomerBootCoin)
        .andRoute(PUT("/api/v2/p2pservice/{id}"), handler::editCustomerBootCoin);
  }
}
