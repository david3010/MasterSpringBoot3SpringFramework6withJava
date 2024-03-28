package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Future;

import java.time.LocalDate;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private long id;

    private String username;
    @Size(min = 10, message = "Ingrese mas de 10 caracteres")
    private String description;
    private boolean isDone;
    @Future(message = "La fecha debe ser futura")
    private LocalDate targetDate;

    public Todo() {
        super();
    }

    public Todo(long id, String username, String description, LocalDate targetDate, boolean isDone) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return String.format("Todo [id=%s, username=%s, description=%s, targetDate=%s, isDone=%s]", id, username, description, targetDate, isDone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Todo todo = (Todo) obj;
        return id == todo.id;
    }
}
