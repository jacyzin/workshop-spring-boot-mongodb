package com.jacyzin.workshopspringbootmongodb.config;

import com.jacyzin.workshopspringbootmongodb.domain.Post;
import com.jacyzin.workshopspringbootmongodb.domain.User;
import com.jacyzin.workshopspringbootmongodb.dto.AuthorDTO;
import com.jacyzin.workshopspringbootmongodb.repository.PostRepository;
import com.jacyzin.workshopspringbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User bob = new User(null, "Bob Grey", "bobv_grey@live.com");
        User marina = new User(null, "Marina Lubachevsck", "marina_luba@live.com");

        userRepository.saveAll(Arrays.asList(bob, marina));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para SP, abraços", new AuthorDTO(marina));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(marina));

        postRepository.saveAll(Arrays.asList(post1, post2));

        marina.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(marina);

    }
}
