package com.jacyzin.workshopspringbootmongodb.repository;

import com.jacyzin.workshopspringbootmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}