package com.marketplace.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.marketplace.model.Listing;


public interface ListingRepository extends MongoRepository<Listing, String> {
    List<Listing> findBySellerId(String sellerId);
}

