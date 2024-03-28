package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.Date;

//@Controller
@SessionAttributes("username")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = "/list-todos")
    public String showTodos(ModelMap model) {
        String username = getLoggedInUsername();
        model.addAttribute("todos", todoService.retrieveTodosByUsername(username));
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo")
    public String addNewTodo(ModelMap modelMap) {
        String username = (String) modelMap.get("username");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusDays(1), false);
        modelMap.addAttribute("todo", todo);
        return "add-todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errors = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors = " * Campo:" + error.getObjectName() + " - " + error.getDefaultMessage() + " \n ";
            }
            modelMap.addAttribute("errors", errors);
            return "add-todo";
        }
        String username = getLoggedInUsername();
        todoService.createTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    private String delete(@RequestParam long id) {
        todoService.deleteTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    private String update(ModelMap modelMap, @RequestParam long id) {
        Todo todo = todoService.retrieveTodo(id);
        if (todo != null) {
            modelMap.addAttribute("todo", todo);
            return "update-todo";
        } else {
            return "redirect:list-todos";
        }
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String update(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errors = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors = " * Campo:" + error.getObjectName() + " - " + error.getDefaultMessage() + " \n ";
            }
            modelMap.addAttribute("errors", errors);
            return "add-todo";
        }
        String username = getLoggedInUsername();
        todo.setUsername(username);
        todoService.updateTodo(todo.getId(), todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
}
