package com.in28minutes.learnspringsecurity.resources;

import com.in28minutes.learnspringsecurity.todo.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TodoResource {

    private final Logger logger = LoggerFactory.getLogger(TodoResource.class);

    public static List<Todo> TODOS = Arrays.asList(
            new Todo(1, "Read a book"),
            new Todo(2, "Study for the math exam"),
            new Todo(2, "Study for the chemistry exam")
    );

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS;
    }

    @GetMapping("/todos/{id}")
    public Todo retrieveTodo(@PathVariable(name = "id") int id) {
        return TODOS.get(id);
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        logger.info("created todo: {}", todo);
        return todo;
    }
}
