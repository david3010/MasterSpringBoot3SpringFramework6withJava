package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "in28Minutes", "Learn Spring MVC", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28Minutes", "Learn Struts", LocalDate.now().plusMonths(2), false));
        todos.add(new Todo(++todosCount, "in28Minutes", "Learn Hibernate", LocalDate.now().plusDays(10), false));
    }

    public void createTodo(String username, String description, LocalDate targetDate, Boolean isDone) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, isDone);
        todos.add(todo);
    }

    public void deleteTodo(long id) {
        // Some business logic
        todos.removeIf(todo -> todo.getId() == id);
    }

    public List<Todo> retrieveTodos() {
        // Some business logic
        return todos;
    }

    public void updateTodo(long id, Todo todo) {
        // Some business logic
        todos.removeIf(t -> t.getId() == id);
        todos.add(todo);
    }

    public Todo retrieveTodo(long id) {
        // Some business logic
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }

    public List<Todo> retrieveTodosByUsername(String userName) {
        // Some business logic
        return todos.stream().filter(todo -> todo.getUsername().equals(userName)).toList();
    }
}
