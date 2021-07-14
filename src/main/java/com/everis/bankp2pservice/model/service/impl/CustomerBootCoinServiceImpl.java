package com.everis.bankp2pservice.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.bankp2pservice.model.dao.CustomerBootCoinDao;
import com.everis.bankp2pservice.model.dao.TypeDocumentDao;
import com.everis.bankp2pservice.model.document.CustomerBootCoinDoc;
import com.everis.bankp2pservice.model.document.TypeDocumentDoc;
import com.everis.bankp2pservice.model.service.CustomerBootCoinService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerBootCoinServiceImpl implements CustomerBootCoinService {
  
  @Autowired
  private CustomerBootCoinDao customerBootCoinDao;
  
  @Autowired
  private TypeDocumentDao typeDocumentDao;

  @Override
  public Flux<CustomerBootCoinDoc> findAll() {
    return customerBootCoinDao.findAll();
  }

  @Override
  public Mono<CustomerBootCoinDoc> findById(String id) {
    return customerBootCoinDao.findById(id);
  }

  @Override
  public Mono<CustomerBootCoinDoc> save(
      CustomerBootCoinDoc customerBootCoinDoc) {
    return customerBootCoinDao.save(customerBootCoinDoc);
  }

  @Override
  public Mono<Void> delete(
      CustomerBootCoinDoc customerBootCoinDoc) {
    return customerBootCoinDao.delete(customerBootCoinDoc);
  }

  @Override
  public Flux<TypeDocumentDoc> findAllDocument() {
    return typeDocumentDao.findAll();
  }

  @Override
  public Mono<TypeDocumentDoc> findByIdDocument(String id) {
    return typeDocumentDao.findById(id);
  }

  @Override
  public Mono<TypeDocumentDoc> saveDocument(TypeDocumentDoc typeDocumentDoc) {
    return typeDocumentDao.save(typeDocumentDoc);
  }

}
