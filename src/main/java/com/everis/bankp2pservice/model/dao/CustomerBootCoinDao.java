package com.everis.bankp2pservice.model.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.everis.bankp2pservice.model.document.CustomerBootCoinDoc;

public interface CustomerBootCoinDao extends ReactiveMongoRepository<CustomerBootCoinDoc, String> {

}
