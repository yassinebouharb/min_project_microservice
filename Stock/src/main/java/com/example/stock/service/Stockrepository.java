package com.example.stock.service;

import com.example.stock.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Stockrepository extends MongoRepository<Stock, String> {

    Stock findByProductId(String productId);
}