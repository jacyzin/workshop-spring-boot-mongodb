package com.jacyzin.workshopspringbootmongodb.resource;

import com.jacyzin.workshopspringbootmongodb.domain.Post;
import com.jacyzin.workshopspringbootmongodb.domain.User;
import com.jacyzin.workshopspringbootmongodb.dto.UserDTO;
import com.jacyzin.workshopspringbootmongodb.service.PostService;
import com.jacyzin.workshopspringbootmongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Optional<Post> post = postService.findById(id);
        return ResponseEntity.ok().body(post.get());
    }

}
