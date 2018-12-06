package com.jacyzin.workshopspringbootmongodb.config;

import com.jacyzin.workshopspringbootmongodb.domain.User;
import com.jacyzin.workshopspringbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        User bob = new User(null, "Bob Grey", "bobv_grey@live.com");
        User marina = new User(null, "Maria Lubachevsck", "marina_luba@live.com");
        userRepository.saveAll(Arrays.asList(bob, marina));

    }
}
