package com.marketplace.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.model.User;

import java.util.List;
import java.util.Optional;

// User Repository
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByAuth0Id(String auth0Id);
}
