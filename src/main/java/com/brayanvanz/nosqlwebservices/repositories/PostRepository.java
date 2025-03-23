package com.brayanvanz.nosqlwebservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.brayanvanz.nosqlwebservices.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
