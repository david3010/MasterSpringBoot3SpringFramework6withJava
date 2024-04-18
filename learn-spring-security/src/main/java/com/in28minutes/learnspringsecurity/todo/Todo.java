package com.in28minutes.learnspringsecurity.todo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Todo {
    @JsonProperty("id")
    private int id;
    @JsonProperty("description")
    private String description;

    public Todo() {
    }

    public Todo(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
