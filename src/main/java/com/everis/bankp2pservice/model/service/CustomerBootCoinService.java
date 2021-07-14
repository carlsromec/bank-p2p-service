package com.everis.bankp2pservice.model.service;

import com.everis.bankp2pservice.model.document.CustomerBootCoinDoc;
import com.everis.bankp2pservice.model.document.TypeDocumentDoc;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerBootCoinService {
  
  public Flux<CustomerBootCoinDoc> findAll();
  public Mono<CustomerBootCoinDoc> findById(String id);
  public Mono<CustomerBootCoinDoc> save(CustomerBootCoinDoc customerBootCoinDoc);
  public Mono<Void> delete(CustomerBootCoinDoc customerBootCoinDoc);
  
  public Flux<TypeDocumentDoc> findAllDocument();
  public Mono<TypeDocumentDoc> findByIdDocument(String id);
  public Mono<TypeDocumentDoc> saveDocument(TypeDocumentDoc typeDocumentDoc);
  

}
