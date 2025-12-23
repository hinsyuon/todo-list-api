package com.example.todolistapi.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name", nullable = true, unique = false)
    private String taskName;
    @Column(name = "completed", nullable = true)
    private Boolean completed;

    
    public Task(String taskName, Boolean isCompleted) {
        this.taskName = taskName;
        this.completed = isCompleted;
    }

    public Task() {

    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setCompleted(Boolean isCompleted) {
        this.completed = isCompleted;
    }

    public Boolean isCompleted() {
        return completed;
    }
}
