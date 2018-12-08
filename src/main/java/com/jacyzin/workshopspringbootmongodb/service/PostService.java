package com.jacyzin.workshopspringbootmongodb.service;

import com.jacyzin.workshopspringbootmongodb.domain.Post;
import com.jacyzin.workshopspringbootmongodb.domain.User;
import com.jacyzin.workshopspringbootmongodb.dto.UserDTO;
import com.jacyzin.workshopspringbootmongodb.repository.PostRepository;
import com.jacyzin.workshopspringbootmongodb.repository.UserRepository;
import com.jacyzin.workshopspringbootmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    };

    public Optional<Post> findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (!post.isPresent())
            throw new ObjectNotFoundException("Objeto não encontrado");

        return post;
    }

    public Post insert(Post post) {
        return postRepository.insert(post);
    }

    public void delete(String id) {
        findById(id);
        postRepository.deleteById(id);
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

}
