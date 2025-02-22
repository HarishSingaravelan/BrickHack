package com.marketplace.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.model.Listing;

@Repository
public interface ListingRepository extends MongoRepository<Listing, String> {
    List<Listing> findByCategory(String category);
    List<Listing> findByLocation(String location);
    List<Listing> findBySellerId(String sellerId);
}
