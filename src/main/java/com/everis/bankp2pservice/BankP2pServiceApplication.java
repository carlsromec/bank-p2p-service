package com.everis.bankp2pservice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.everis.bankp2pservice.model.document.CustomerBootCoinDoc;
import com.everis.bankp2pservice.model.document.TypeDocumentDoc;
import com.everis.bankp2pservice.model.service.CustomerBootCoinService;

import reactor.core.publisher.Flux;
@EnableEurekaClient
@SpringBootApplication
public class BankP2pServiceApplication implements CommandLineRunner {
  
  @Autowired
  private CustomerBootCoinService customerBootCoinService;
  @Autowired
  private ReactiveMongoTemplate mongoTemplate;
  
  private static final Logger log = LoggerFactory.getLogger(BankP2pServiceApplication.class);
  
	public static void main(String[] args) {
		SpringApplication.run(BankP2pServiceApplication.class, args);
	}
  @Override
  public void run(String... args) throws Exception {
    mongoTemplate.dropCollection("CustomerBootCoinDoc").subscribe();
    mongoTemplate.dropCollection("TypeDocumentDoc").subscribe();
    
    TypeDocumentDoc DNI = new TypeDocumentDoc("DNI");
    TypeDocumentDoc CEX = new TypeDocumentDoc("CEX");
    TypeDocumentDoc pasaporte = new TypeDocumentDoc("Pasaporte");
    
    Flux.just(DNI, CEX, pasaporte)
    .flatMap(customerBootCoinService::saveDocument)
    .doOnNext(t ->{
      log.info("TypeDocumentDoc created: " + t.getDescription() + ", Id: " + t.getId());
    }).thenMany(
        Flux.just(new CustomerBootCoinDoc( "30908070","andres@gmail.com","999444333",DNI),
            new CustomerBootCoinDoc("223453456","luis@gmail.com","999222333",CEX),
            new CustomerBootCoinDoc("345678","paola@gmail.com","999111777",pasaporte)
            
            )
        .flatMap(customerBoot ->{
          return customerBootCoinService.save(customerBoot);
        })
    ).subscribe(customerBoot -> log.info("Insert: " + customerBoot.getId()));
  }

}
