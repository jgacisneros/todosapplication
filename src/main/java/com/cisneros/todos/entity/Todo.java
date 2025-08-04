package com.cisneros.todos.entity;

import jakarta.persistence.*;

@Table(name = "todos")
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int priority;

    @Column(nullable = false)
    private boolean complete;

    public Todo(){}

    public Todo(String title, String description, int priority, boolean complete) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.complete = complete;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isComplete() {
        return complete;
    }
}
