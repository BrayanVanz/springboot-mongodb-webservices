package com.brayanvanz.nosqlwebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brayanvanz.nosqlwebservices.domain.Post;
import com.brayanvanz.nosqlwebservices.repositories.PostRepository;
import com.brayanvanz.nosqlwebservices.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }
}
