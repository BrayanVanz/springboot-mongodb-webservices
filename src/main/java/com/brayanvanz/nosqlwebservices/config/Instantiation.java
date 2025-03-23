package com.brayanvanz.nosqlwebservices.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brayanvanz.nosqlwebservices.domain.Post;
import com.brayanvanz.nosqlwebservices.domain.User;
import com.brayanvanz.nosqlwebservices.dto.AuthorDTO;
import com.brayanvanz.nosqlwebservices.dto.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018", fmt), "Excited to travel", "I will go on a trip abroad!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2018", fmt), "Good Morning", "I woke up feeling good today :)", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Have a nice trip!", LocalDate.parse("21/03/2018", fmt), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Enjoy :D", LocalDate.parse("22/03/2018", fmt), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Good day to you!", LocalDate.parse("23/03/2018", fmt), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }

}
