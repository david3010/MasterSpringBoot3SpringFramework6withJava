package com.in28minutes.rest.webservices.restfullwebservices.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().plusYears(1)));
        users.add(new User(++usersCount, "Eva", LocalDate.now().plusYears(1)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().plusYears(1)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findById(int id) {
        Predicate<? super User> predicate = users -> users.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = users -> users.getId().equals(id);
        users.removeIf(predicate);
    }
}
