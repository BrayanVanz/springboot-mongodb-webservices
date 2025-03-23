package com.brayanvanz.nosqlwebservices.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brayanvanz.nosqlwebservices.domain.Post;
import com.brayanvanz.nosqlwebservices.domain.User;
import com.brayanvanz.nosqlwebservices.repositories.PostRepository;
import com.brayanvanz.nosqlwebservices.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, LocalDate.parse("21/03/2018", fmt), "Excited to travel", "I will go on a trip abroad!", maria);
        Post post2 = new Post(null, LocalDate.parse("23/03/2018", fmt), "Good Morning", "I woke up feeling good today :)", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }

}
