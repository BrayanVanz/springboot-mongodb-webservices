package com.brayanvanz.nosqlwebservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brayanvanz.nosqlwebservices.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
