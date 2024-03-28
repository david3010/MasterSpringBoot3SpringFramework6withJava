package com.in28minutes.rest.webservices.restfullwebservices.user;

import com.in28minutes.rest.webservices.restfullwebservices.jpa.PostRepository;
import com.in28minutes.rest.webservices.restfullwebservices.jpa.UserRepository;
import com.in28minutes.rest.webservices.restfullwebservices.post.Post;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable int id) {
        User user = this.userRepository.findById(id).orElse(null);
        if (user == null)
            throw new UserNotFoundException("EL usuario con id:" + id + " no existe.");
        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        userEntityModel.add(linkBuilder.withRel("all-users"));
        return userEntityModel;
    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> retrievePostsByUserId(@PathVariable int id) {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("EL usuario con id:" + id + " no existe.");
        return user.get().getPostList();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userRepository.deleteById(id);
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        User userDb = this.userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDb.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping(path = "/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@RequestBody Post post, @PathVariable int id) throws URISyntaxException {
        Optional<User> user = this.userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("EL usuario con id:" + id + " no existe.");

        post.setUser(user.get());
        this.postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(user.get().getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
