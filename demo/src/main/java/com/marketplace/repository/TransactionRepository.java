package com.marketplace.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByBuyerId(String buyerId);
    List<Transaction> findBySellerId(String sellerId);
}
