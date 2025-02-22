package com.marketplace.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.model.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findBySenderId(String senderId);
    List<Message> findByReceiverId(String receiverId);
    List<Message> findByListingId(String listingId);
}
