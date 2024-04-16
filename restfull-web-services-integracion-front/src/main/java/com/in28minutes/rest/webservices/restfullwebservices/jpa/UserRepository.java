package com.in28minutes.rest.webservices.restfullwebservices.jpa;

import com.in28minutes.rest.webservices.restfullwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
