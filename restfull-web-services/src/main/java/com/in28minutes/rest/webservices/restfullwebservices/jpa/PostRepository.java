package com.in28minutes.rest.webservices.restfullwebservices.jpa;

import com.in28minutes.rest.webservices.restfullwebservices.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
